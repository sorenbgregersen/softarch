package hotciv.standard;

import hotciv.framework.*;

import hotciv.variance.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/** Skeleton class for AlphaCiv test cases

 Updated Oct 2015 for using Hamcrest matchers

 This source code is from the book
 "Flexible, Reliable Software:
 Using Patterns and Agile Development"
 published 2010 by CRC Press.
 Author:
 Henrik B Christensen
 Department of Computer Science
 Aarhus University

 Please visit http://www.baerbak.com/ for further information.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
public class TestAlphaCiv {
    private GameImpl game;

    /**
     * Fixture for alphaciv testing.
     */
    @Before
    public void setUp() {
        game = new GameImpl(new AlphaAging(), new AlphaWinning(), new AlphaUnitActions(), new AlphaMap(), new AlphaAttack());
    }

    @Test
    public void shouldHaveRedCityAt1_1() {
        City c = game.getCityAt(new Position(1, 1));
        assertThat("There should be a city at (1,1)",
                c, is(notNullValue()));

        Player p = c.getOwner();
        assertThat("The city should be owned by RED player",
                p, is(Player.RED));
    }

    @Test
    public void shouldHaveBlueCityAt4_1() {
        City c = game.getCityAt(new Position(4, 1));
        assertThat("There should be a city at (4,1)",
                c, is(notNullValue()));

        Player p = c.getOwner();
        assertThat("The city should be owned by Blue player",
                p, is(Player.BLUE));
    }

    @Test
    public void citiesProduce6ProductionPerRound(){
        CityImpl c = game.getCityAt(new Position(1, 1));
        assertThat("Cities produce 6 production", c.getProductionTreasury() ,is(6));
    }

    @Test
    public void thereIsOceanAt1_0() {
        Tile t1_0 = game.getTileAt(new Position(1, 0));
        String tiletype = t1_0.getTypeString();
        assertThat("There should be ocean at (1,0)", tiletype, is("ocean"));
    }

    @Test
    public void thereIsHillsAt0_1() {
        Tile t0_1 = game.getTileAt(new Position(0, 1));
        String tiletype = t0_1.getTypeString();
        assertThat("There should be hills at (0,1)", tiletype, is("hills"));
    }

    @Test
    public void thereIsMountainsAt2_2() {
        Tile t2_2 = game.getTileAt(new Position(2, 2));
        String tiletype = t2_2.getTypeString();
        assertThat("There should be mountain at (2,2)", tiletype, is("mountain"));
    }

    @Test
    public void plainsAt9_9And16_16And12_4() {

        String t9_9 = game.getTileAt(new Position(9, 9)).getTypeString();
        assertThat("There should be plains at (9,9)"
                , t9_9, is("plains"));

        String t15_15 = game.getTileAt(new Position(15, 15)).getTypeString();
        assertThat("There should be plains at (15,15)"
                , t15_15, is("plains"));

        String t12_4 = game.getTileAt(new Position(12, 4)).getTypeString();
        assertThat("There should be plains at (12,4)"
                , t12_4, is("plains"));
    }

    @Test
    public void redWinsInYear3000BC() {
        for(int i = 0 ; i < 10 ; i++){
            game.endOfRound();
        }
        assertThat("year is 3000BC", game.getAge(), is(-3000));
        assertThat("red wins", game.getWinner(), is(Player.RED));
    }

    @Test
    public void gameStartsInYear4000BC() {
        assertThat("the game starts in year 4000 BC", game.getAge(), is(-4000));
    }

    @Test
    public void eachTurnLasts100Years() {
        assertThat("each turn lasts 100 year", game.getAge(), is(-4000));
        game.endOfRound();
        assertThat("each turn lasts 100 year", game.getAge(), is(-3900));
    }

    @Test
    public void populationIsAlways1() {
        City c = game.getCityAt(new Position(1, 1));
        assertThat("cities population is always 1", c.getSize(), is(1));
    }

    @Test
    public void afterRedItIsBlue() {
        assertThat("Red has turn 1", game.getPlayerInTurn(), is(Player.RED));
        game.endOfTurn();
        assertThat("It is blue after red", game.getPlayerInTurn(), is(Player.BLUE));
        game.endOfTurn();
        assertThat("Red after blue", game.getPlayerInTurn(), is(Player.RED));
    }

    @Test
    public void thereShouldBeARedArcherAt2_0() {
        Unit u2_0 = game.getUnitAt(new Position(2,0));
        assertThat("there should be an archer at 2,0", u2_0.getTypeString(), is(GameConstants.ARCHER));
        assertThat("the archer belongs to red", u2_0.getOwner(), is(Player.RED));
    }

    @Test
    public void thereShouldBeABlueLegionAt3_2() {
        Unit u3_2 = game.getUnitAt(new Position(3, 2));
        assertThat("there should be a legion at 3,2", u3_2.getTypeString(), is(GameConstants.LEGION));
        assertThat("the legion belongs to blue", u3_2.getOwner(), is(Player.BLUE));
    }

    @Test
    public void thereShouldBeARedSettlerAt4_3() {
        Unit u4_3 = game.getUnitAt(new Position(4, 3));
        assertThat("there should be a settler at 4,3", u4_3.getTypeString(), is(GameConstants.SETTLER));
        assertThat("the settler belongs to Red", u4_3.getOwner(), is(Player.RED));
    }

    @Test
    public void shouldNotMoveOverMountain(){
        game.moveUnit(new Position(2,0), new Position(2,1));
        assertThat("The unit can not move onto the mountain",
                game.moveUnit(new Position(2, 1), new Position(2, 2)), is(false));
        assertThat("There is no unit on the mountains",
                game.getUnitAt(new Position(2, 2)), is(nullValue()));
    }

    @Test
    public void blueMovesOntoRedAndWins() {
        game.endOfTurn();
        game.moveUnit(new Position(3, 2), new Position(4, 3));
        assertThat("blue moves to red and wins",
                game.getUnitAt(new Position(4, 3)).getOwner(), is(Player.BLUE));
    }

    @Test
    public void redMovesOntoBlueAndWins() {
        game.moveUnit(new Position(4, 3), new Position(3, 2));
        assertThat("red moves to blue and wins",
                game.getUnitAt(new Position(3, 2)).getOwner(), is(Player.RED));
    }

    @Test
    public void shouldMoveRedArcherFrom2_0To2_1() {
        Unit unit = game.getUnitAt(new Position(2, 0));
        // move unit from 2,0 to 2,1
        game.moveUnit(new Position(2, 0), new Position(2, 1));
        assertThat("the red archer has moved to 2_1",
                game.getUnitAt(new Position(2, 1)), is(sameInstance(unit)));
    }

    @Test
    public void unitsAreMovedAndNotOnlyCopied() {
        game.getUnitAt(new Position(2, 0));
        game.moveUnit(new Position(2, 0), new Position(2, 1));
        assertThat("the unit moved is not present at its original position after move",
                game.getUnitAt(new Position(2, 0)), is(nullValue()));
    }

    @Test
    public void redCannotMoveBluesUnit() {
        assertFalse("red can not move blue's legion from 3,2 to 3,3",
                game.moveUnit(new Position(3, 2), new Position(3, 3)));
    }

    @Test
    public void shouldAllowOnlyOneUnitAtATile() {
        game.moveUnit(new Position(2, 0), new Position(3,1));
        game.endOfTurn();
        game.endOfTurn();
        game.moveUnit(new Position(3,1), new Position(4,2));
        game.endOfTurn();
        game.endOfTurn();
                assertFalse("two units cannot be at the same tile at the same time",
                        game.moveUnit(new Position(4, 2), new Position(4, 3)));
    }

    @Test
    public void unitsCanOnlyMoveOneTilePerTurn(){
        assertFalse("the game return false if a unit is moved more then one tile",
                game.moveUnit(new Position(2, 0), new Position(3,3)));
    }

    @Test
    public void shouldConquerCityWithUnit() {
        game.moveUnit(new Position(4, 3), new Position(4, 2));
        game.endOfTurn();
        game.endOfTurn();
        game.moveUnit(new Position(4, 2), new Position(4, 1));
        assertThat("is a unit moves onto a city, the city is conquered",
                game.getCityAt(new Position(4, 1)).getOwner(), is(Player.RED));
    }

    @Test
    public void cityShouldHaveCollected10ProductionTreasury() {
        CityImpl c = new CityImpl(Player.RED);
        c.increaseProductionTreasury(6);
        assertTrue("a city should have produced more than 10 production treasury",
                c.getProductionTreasury() > 10);
    }

    @Test
    public void setCityUnitProductionToArcher(){
        CityImpl c = new CityImpl(Player.RED);
        c.setProduction(GameConstants.ARCHER);
        assertThat("the city produces archers", c.getProduction(), is(GameConstants.ARCHER));
    }

    @Test
    public void shouldProduceUnitWhenTreasuryIsSufficient() {
        CityImpl c = game.getCityAt(new Position(1, 1));
        c.setProduction(GameConstants.ARCHER);
        game.endOfRound();
        assertThat("an archer is produced when treasury is 10 or higher",
                game.getUnitAt(new Position(1,1)).getTypeString(),is(GameConstants.ARCHER) );
    }

    @Test
    public void shouldPlaceThreeArchersAroundCity(){
        CityImpl c = game.getCityAt(new Position(1, 1));
        c.setProduction(GameConstants.ARCHER);
        game.endOfRound();
        game.endOfRound();
        game.endOfRound();
        game.endOfRound();
        assertThat("there should be an archer at (0,2)",
                game.getUnitAt(new Position(0,2)).getTypeString(),is(GameConstants.ARCHER));
        assertThat("production treasury should be 4", c.getProductionTreasury(), is(0));
    }
}