package hotciv.variance.factories;

import hotciv.framework.*;

public interface AbstractFactory {

    WorldAgingStrategy createAgingStrategy();

    WinningStrategy createWinningStrategy();

    UnitActionStrategy createUnitActionStrategy();

    WorldMapStrategy createMapStrategy();

    AttackStrategy createAttackStrategy();
}
