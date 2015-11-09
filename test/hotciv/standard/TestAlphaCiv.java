package hotciv.standard;

import hotciv.framework.*;

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
    private Game game;

    /**
     * Fixture for alphaciv testing.
     */
    @Before
    public void setUp() {
        game = new GameImpl();
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
    public void thereIsOceanAt1_0() {
        Tile t1_0 = game.getTileAt(new Position(1, 0));
        String tiletype = t1_0.getTypeString();
        assertThat("There should ocean at (1,0)", tiletype, is("ocean"));
    }
    @Test
    public void thereIsHillsAt0_1() {
        Tile t0_1 = game.getTileAt(new Position(0, 1));
        String tiletype = t0_1.getTypeString();
        assertThat("There should Hills at (0,1)", tiletype, is("hills"));
    }


    @Test
    public void redWinsinYear3000BC() {
        assertThat("year is 3000BC", game.getAge(), is(3000));
        assertThat("red wins", game.getWinner(), is(Player.RED));
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
}

