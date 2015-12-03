package hotciv.variance.factories;
import hotciv.framework.*;
import hotciv.variance.*;

public class SemiCivFactory implements AbstractFactory {
    private String[] layout;
    private DieStrategy die1, die2;

    public SemiCivFactory(String[] layout,DieStrategy d1, DieStrategy d2){
        this.layout = layout;
        this.die1 = d1;
        this.die2 = d2;
    }

    @Override
    public WorldAgingStrategy createAgingStrategy() {
        return new BetaAging();
    }

    @Override
    public WinningStrategy createWinningStrategy() {
        return new EpsilonWinning();
    }

    @Override
    public UnitActionStrategy createUnitActionStrategy() {
        return new GammaUnitActions();
    }

    @Override
    public WorldMapStrategy createMapStrategy() {
        return new DeltaMap(layout);
    }

    @Override
    public AttackStrategy createAttackStrategy() {
        return new EpsilonAttack(die1, die2);
    }
}
