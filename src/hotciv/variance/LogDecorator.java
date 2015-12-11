package hotciv.variance;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.standard.Decorator;
import hotciv.standard.GameImpl;

public class LogDecorator extends Decorator {
    public LogDecorator(Game decoratedGame) {
        super(decoratedGame);

    }

    @Override
    public boolean moveUnit(Position from, Position to) {
        System.out.println(decoratedGame.getUnitAt(from)+"moves from"+ from +"to"+to);
        return decoratedGame.moveUnit(from, to);


    }
}
