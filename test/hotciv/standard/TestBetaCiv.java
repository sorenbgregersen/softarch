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
    private ProgressiveAgeing  progressiveAgeing;

    /**
     * Fixture for alphaciv testing.
     */
    @Before
    public void setUp() {
        game = new GameImpl(progressiveAgeing);
        progressiveAgeing = new ProgressiveAgeing();

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
        assertThat("Around the birth of christ the squence -100, -1,",progressiveAgeing.calculateWorldAge(-100), is(-1));
        assertThat("Around the birth of christ the squence -1, +1,",progressiveAgeing.calculateWorldAge(-1), is(+1));
        assertThat("Around the birth of christ the squence +1, +50, ",progressiveAgeing.calculateWorldAge(+1),is(50));
    }

    @Test
    public void shouldAge25YearsBetween50And1750AD(){
        assertThat("each turn lasts 50 year between 50 and 1750AC",progressiveAgeing.calculateWorldAge(50),is(100));
    }
    @Test
    public void shouldAge5YearsBetween1750And1900AD(){
        assertThat("each turn lasts 25 year between 1750 and 1900AC",progressiveAgeing.calculateWorldAge(1750),is(1775));
    }
    @Test
    public void shouldAge1YearsBetween1900And1970AD() {
        assertThat("each turn lasts 5 year after 1900AC", progressiveAgeing.calculateWorldAge(1900), is(1905));

    }

    @Test
    public void shouldAge1YearsAfter1970AD(){
        assertThat("each turn lasts 1 year after 1970AC",progressiveAgeing.calculateWorldAge(2015),is(2016));
    }
}
