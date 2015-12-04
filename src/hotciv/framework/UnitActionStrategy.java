package hotciv.framework;

import hotciv.standard.GameImpl;

public interface UnitActionStrategy {
    void performUnitAction(GameImpl game, Position p);
}
