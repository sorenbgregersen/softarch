package hotciv.standard;

import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variance.ThetaCiv;
import hotciv.variance.factories.ThetaCivFactory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestThetaCiv {
    private GameImpl game;
    private UnitImpl redChariot;
    /**
     * Fixture for ThetaCiv testing.
     */

    @Before
    public void setUp() {
        game = new GameImpl(new ThetaCivFactory());
        redChariot = new UnitImpl(ThetaCiv.CHARIOT, Player.RED);
        game.unitMap.put(new Position(5, 0), redChariot);
    }

    @Test
    public void thereShouldBeARedChariotAt5_0() {
        assertThat("there should be a chariot at 5,0", redChariot.getTypeString(), is(ThetaCiv.CHARIOT));
        assertThat("the chariot belongs to red", redChariot.getOwner(), is(Player.RED));
    }

    @Test
    public void shouldPerformChariotAction(){
        Position p = new Position(5,0);
        game.performUnitActionAt(p);
        assertThat("When chariot performs its action, it cannot move",
                game.getUnitAt(p).getMoveCount(), is(0));
        assertThat("when chariot performs action its defensive strength is 2" ,
                game.getUnitAt(p).getDefensiveStrength(), is(2));
    }
}
