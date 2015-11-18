package hotciv.standard;

import hotciv.framework.*;

import hotciv.variance.ProgressiveAgeing;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by Alex on 18-11-2015.
 */
public class TestBetaCiv {
    private Game game;
    private ProgressiveAgeing progressiveAgeing = new ProgressiveAgeing();

    /**
     * Fixture for alphaciv testing.
     */
    @Before
    public void setUp() {
        game = new GameImpl(progressiveAgeing);

    }

    @Test
    public void shouldAge100YearsBetween4000And100BC(){
        assertThat("each turn lasts 100 year between 4000BC and 100BC", game.getAge(), is(-4000));
        game.endOfTurn();
        assertThat("each turn lasts 100 year", game.getAge(), is(-3900));
    }
/*
    @Test
    public void shouldAge50YearsBetween50And1750AD(){
        assertThat("each turn lasts 100 year between 4000BC and 100BC", game.getAge(), is(100));
        game.endOfTurn();
        assertThat("each turn lasts 100 year", game.getAge(), is(150));
    }

    @Test
    public void shouldAge25YearsBetween1750And1900AD(){
        assertThat("each turn lasts 100 year between 4000BC and 100BC", game.getAge(), is(-4000));
        game.endOfTurn();
    }
    */
}
