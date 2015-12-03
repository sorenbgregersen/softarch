package hotciv.variance.factories;

import hotciv.framework.*;
import hotciv.variance.AlphaAging;
import hotciv.variance.AlphaMap;
import hotciv.variance.AlphaUnitActions;

public class StubFactory implements AbstractFactory {
    AttackStrategy attackStrategy;
    WinningStrategy winningStrategy;

    public StubFactory(AttackStrategy attackStrategy, WinningStrategy winningStrategy){
        this.attackStrategy = attackStrategy;
        this.winningStrategy = winningStrategy;
    }
    @Override
    public WorldAgingStrategy createAgingStrategy() {
        return new AlphaAging();
    }

    @Override
    public WinningStrategy createWinningStrategy() {
        return winningStrategy;
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
        return attackStrategy;
    }
}
