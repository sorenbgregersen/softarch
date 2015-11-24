package hotciv.standard;

import hotciv.framework.*;

import hotciv.variance.AlphaMap;
import hotciv.variance.ConquerBasedWinning;
import hotciv.variance.ProgressiveAgeing;
import hotciv.variance.AlphaUnitActions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestBetaCiv {
    private GameImpl game;
    private ProgressiveAgeing  progressiveAgeing;
    private ConquerBasedWinning conquerBasedWinning;
    private UnitActionStrategy alphaUnitActions;
    private AlphaMap alphaMap;
    /**
     * Fixture for betaciv testing.
     */
    @Before
    public void setUp() {
        progressiveAgeing = new ProgressiveAgeing();
        conquerBasedWinning = new ConquerBasedWinning();
        alphaUnitActions = new AlphaUnitActions();
        alphaMap = new AlphaMap();
        game = new GameImpl(progressiveAgeing, conquerBasedWinning, alphaUnitActions, alphaMap);
    }

    @Test
    public void shouldAge100YearsBetween4000And100BC(){
        assertThat("each turn lasts 100 year between 4000BC and 100BC", progressiveAgeing.calculateWorldAge(-4000), is(-3900));
    }

    @Test
    public void shouldAge50YearsBetween50And1750AD(){
        assertThat("each turn lasts 100 year between 4000BC and 100BC", progressiveAgeing.calculateWorldAge(100), is(150));
    }

    @Test
    public void aroundTheBirthOfChrist(){
        assertThat("Around the birth of christ the sequence -100, -1,",progressiveAgeing.calculateWorldAge(-100), is(-1));
        assertThat("Around the birth of christ the sequence -1, +1,",progressiveAgeing.calculateWorldAge(-1), is(+1));
        assertThat("Around the birth of christ the sequence +1, +50, ",progressiveAgeing.calculateWorldAge(+1),is(50));
    }

    @Test
    public void shouldAge25YearsBetween1750And1900AD(){
        assertThat("each turn lasts 25 year between 1750 and 1900AC",progressiveAgeing.calculateWorldAge(1750),is(1775));
    }

    @Test
    public void shouldAge5YearsBetween1900And1970AD() {
        assertThat("each turn lasts 5 year after 1900AC", progressiveAgeing.calculateWorldAge(1900), is(1905));
    }

    @Test
    public void shouldAge1YearsAfter1970AD(){
        assertThat("each turn lasts 1 year after 1970AC",progressiveAgeing.calculateWorldAge(2015),is(2016));
    }

    @Test
    public void shouldWinWhenOnePlayerConquersAllCities() {
        game.moveUnit(new Position(4,3), new Position(4,2));
        game.endOfTurn();
        game.endOfTurn();
        game.moveUnit(new Position(4,2), new Position(4,1));
        assertThat("red wins when red conquers blue's city",
                game.getWinner(), is(Player.RED));
    }
}
