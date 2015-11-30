package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.variance.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestDeltaCiv {
    private GameImpl game;

    /*
    Creates DeltaCiv which is identical to AlphaCiv except it implements
    a different map, here called deltaMap, which refers to the variance class
    called DeltaMap
    */

    @Before
    public void setUp() {
        String[] layout = new String[] {
                "...ooMooooo.....",
                "..ohhoooofffoo..",
                ".oooooMooo...oo.",
                ".ooMMMoooo..oooo",
                "...ofooohhoooo..",
                ".ofoofooooohhoo.",
                "...ooo..........",
                ".ooooo.ooohooM..",
                ".ooooo.oohooof..",
                "offfoooo.offoooo",
                "oooooooo...ooooo",
                ".ooMMMoooo......",
                "..ooooooffoooo..",
                "....ooooooooo...",
                "..ooohhoo.......",
                ".....ooooooooo..",
        };
        game = new GameImpl(new AlphaAging(), new AlphaWinning(), new AlphaUnitActions(), new DeltaMap(layout), new AlphaAttack());

    }

    /*
    The tests methods tests that there is one instance of all different tile types
    in the created world map. Plains, Mountains, Ocean, Forest, and Hills.
     */

    @Test
    public void shouldReturnMountainAt0_5() {
        assertThat("there is mountains at (0,5)",
                game.getTileAt(new Position(0, 5)).getTypeString(), is(GameConstants.MOUNTAINS));
    }

    @Test
    public void shouldReturnPlainAt1_2() {
        assertThat("there is plains at (1,2)",
                game.getTileAt(new Position(1, 2)).getTypeString(), is(GameConstants.PLAINS));
    }

    @Test
    public void shouldReturnOceanAt6_8() {
        assertThat("there is ocean at (6,8)",
                game.getTileAt(new Position(6, 8)).getTypeString(), is(GameConstants.OCEANS));
    }

    @Test
    public void shouldReturnForestAt12_8() {
        assertThat("there is forest at (12, 8)",
                game.getTileAt(new Position(12, 8)).getTypeString(), is(GameConstants.FOREST));
    }

    @Test
    public void shouldReturnHillsAt14_6() {
        assertThat("there is hills at (14,6)",
                game.getTileAt(new Position(14, 6)).getTypeString(), is(GameConstants.HILLS));
    }
}