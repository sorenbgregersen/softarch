package hotciv.variance;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.standard.Decorator;
import hotciv.standard.GameImpl;

public class LogDecorator extends Decorator {
    public LogDecorator(Game game) {
        super(game);

    }

    @Override
    public boolean moveUnit(Position from, Position to) {
        System.out.println(game.getUnitAt(from)+"moves from"+ from +"to"+to);
        return super.moveUnit(from, to);


    }
}
