package hotciv.standard;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import hotciv.variance.LogDecorator;
import hotciv.variance.factories.AlphaCivFactory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestLogging {
    private GameImpl game;
    Game decoratedGame = new LogDecorator (
            new Decorator(game));

    @Before
    public void setUp() {
        decoratedGame= new GameImpl(new AlphaCivFactory());
        }

    @Test
    public void shouldMoveRedArcherFrom2_0To2_1() {
        Unit unit = game.getUnitAt(new Position(2, 0));
        // move unit from 2,0 to 2,1
        game.moveUnit(new Position(2, 0), new Position(2, 1));
        assertThat("the red archer has moved to 2_1",
                game.getUnitAt(new Position(2, 1)), is(sameInstance(unit)));
    }

}
