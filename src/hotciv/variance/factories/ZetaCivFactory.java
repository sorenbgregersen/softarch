package hotciv.variance.factories;

import hotciv.framework.WinningStrategy;
import hotciv.variance.ZetaWinning;

public class ZetaCivFactory extends BetaCivFactory {
    private WinningStrategy betaWinning, epsilonWinning;

    public ZetaCivFactory(WinningStrategy betaWinning, WinningStrategy epsilonWinning){
        this.betaWinning = betaWinning;
        this.epsilonWinning = epsilonWinning;
    }
    @Override
    public WinningStrategy createWinningStrategy() {
        return new ZetaWinning(betaWinning, epsilonWinning);
    }
}
