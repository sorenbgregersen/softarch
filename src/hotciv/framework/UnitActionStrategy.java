package hotciv.framework;

import hotciv.standard.GameImpl;

/**
 * Created by Søren on 24-11-2015.
 */
public interface UnitActionStrategy {
    void performUnitAction(GameImpl game, Position p);
}
