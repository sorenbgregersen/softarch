package hotciv.variance.factories;

import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.WinningStrategy;
import hotciv.variance.EpsilonAttack;
import hotciv.variance.EpsilonWinning;

public class EpsilonCivFactory extends BasicCivFactory {
    private DieStrategy die1, die2;

    public EpsilonCivFactory(DieStrategy d1, DieStrategy d2){
        this.die1 = d1;
        this.die2 = d2;
    }
    @Override
    public AttackStrategy createAttackStrategy() {
        return new EpsilonAttack(die1, die2);
    }

    @Override
    public WinningStrategy createWinningStrategy() {
        return new EpsilonWinning();
    }
}
