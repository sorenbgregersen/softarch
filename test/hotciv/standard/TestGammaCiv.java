package hotciv.standard;

import hotciv.framework.AttackStrategy;
import hotciv.framework.Position;
import hotciv.variance.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestGammaCiv {
    private GameImpl game;
    private LinearAging linearAging;
    private AlphaWinning turnBasedWinning;
    private GammaUnitActions gammaUnitActions;
    private AlphaMap alphaMap;
    private AttackStrategy alphaAttack;

    @Before
    public void setUp() {
        gammaUnitActions = new GammaUnitActions();
        alphaMap = new AlphaMap();
        alphaAttack = new AlphaAttack();
        game = new GameImpl(linearAging, turnBasedWinning, gammaUnitActions, alphaMap, alphaAttack);
    }

    @Test
    public void shouldPerformSettlerAction() {
        Position p = new Position(4,3);
        game.performUnitActionAt(p);
        assertThat("when settler performs action, it disappears",
                game.getUnitAt(p), is(nullValue()));
        assertThat("when settler performs action, a city is made",
                game.getCityAt(p), is(notNullValue()));
    }

    @Test
    public void shouldPerformArcherAction(){
        Position p = new Position(2,0);
        game.performUnitActionAt(p);
        assertThat("When Archer performs action, it cannot movet",
                game.getUnitAt(p).getMoveCount(), is(0));
        assertThat("when Archer perfoms action, it," ,
                game.getUnitAt(p).getDefensiveStrength(), is(6));
    }

    @Test
    public void shouldreverseArcherAction(){
        Position p = new Position(2,0);
        game.performUnitActionAt(p);
        game.performUnitActionAt(p);
        assertThat("When Archer performs action, it cannot movet",
                game.getUnitAt(p).getMoveCount(), is(1));
        assertThat("When perform Action is called the action reverses",
                game.getUnitAt(p).getDefensiveStrength(), is(3));
    }
}
