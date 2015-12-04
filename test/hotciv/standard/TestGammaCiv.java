package hotciv.standard;

import hotciv.framework.Position;
import hotciv.variance.factories.GammaCivFactory;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestGammaCiv {
    private GameImpl game;

    @Before
    public void setUp() {
        game = new GameImpl(new GammaCivFactory());
    }

    @Test
    public void shouldPerformSettlerAction() {
        Position p = new Position(4,3);
        System.out.println(game.getUnitAt(p).getTypeString());
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
        assertThat("When Archer performs action, it cannot move",
                game.getUnitAt(p).getMoveCount(), is(0));
        assertThat("when Archer perfoms action, it," ,
                game.getUnitAt(p).getDefensiveStrength(), is(6));
    }

    @Test
    public void shouldReverseArcherAction(){
        Position p = new Position(2,0);
        game.performUnitActionAt(p);
        game.performUnitActionAt(p);
        assertThat("When Archer performs action, it cannot movet",
                game.getUnitAt(p).getMoveCount(), is(1));
        assertThat("When perform Action is called the action reverses",
                game.getUnitAt(p).getDefensiveStrength(), is(3));
    }

    @Test
    public void legionShouldNotPerformAnyAction(){
        Position p = new Position(3 ,2);
        game.performUnitActionAt(p);
        assertThat("When legion performs action, nothing happens",
                game.getUnitAt(p).getMoveCount(), is(1));
        assertThat("When legion performs action, nothing happens",
                game.getUnitAt(p).getDefensiveStrength(), is(2));
    }
}
