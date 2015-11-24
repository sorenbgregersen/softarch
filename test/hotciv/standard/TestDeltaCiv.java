package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.variance.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestDeltaCiv {
    private GameImpl game;
    private LinearAging linearAging;
    private TurnBasedWinning turnBasedWinning;
    private AlphaUnitActions alphaUnitActions;
    private DeltaMap deltaMap;

    @Before
    public void setUp() {
        deltaMap = new DeltaMap();
        game = new GameImpl(linearAging, turnBasedWinning, alphaUnitActions, deltaMap);
    }

    @Test
    public void shouldReturnMountainAt0_5And3_3() {
        assertThat("there is mountains at (0,5)",
                game.getTileAt(new Position(0, 5)).getTypeString(), is(GameConstants.MOUNTAINS));
    }
}