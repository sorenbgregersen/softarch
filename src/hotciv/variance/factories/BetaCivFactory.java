package hotciv.variance.factories;

import hotciv.framework.WinningStrategy;
import hotciv.framework.WorldAgingStrategy;
import hotciv.variance.BetaAging;
import hotciv.variance.BetaWinning;

public class BetaCivFactory extends BasicCivFactory {
    @Override
    public WorldAgingStrategy createAgingStrategy() {
        return new BetaAging();
    }

    @Override
    public WinningStrategy createWinningStrategy() {
        return new BetaWinning();
    }
}
