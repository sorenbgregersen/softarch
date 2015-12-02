package hotciv.variance.factories;

import hotciv.framework.*;
import hotciv.variance.*;

public class BasicCivFactory implements AbstractFactory {
    @Override
    public WorldAgingStrategy createAgingStrategy() {
        return new AlphaAging();
    }

    @Override
    public WinningStrategy createWinningStrategy() {
        return new AlphaWinning();
    }

    @Override
    public UnitActionStrategy createUnitActionStrategy() {
        return new AlphaUnitActions();
    }

    @Override
    public WorldMapStrategy createMapStrategy() {
        return new AlphaMap();
    }

    @Override
    public AttackStrategy createAttackStrategy() {
        return new AlphaAttack();
    }
}
