package hotciv.variance;

import hotciv.framework.Player;
import hotciv.framework.WinnerStrategyContext;
import hotciv.framework.WinningStrategy;


public class ZetaWinning implements WinningStrategy {
    private WinningStrategy
            betaWinning, epsilonWinning, currentState;

    public ZetaWinning (WinningStrategy betaWinning, WinningStrategy epsilonWinning){
        this.betaWinning = betaWinning;
        this.epsilonWinning = epsilonWinning;
        this.currentState = null;
    }

    @Override
    public void updateWinningCount(Player attacker) {
        /*
        if(roundCounter <= 20){
            betaWinning.updateWinningCount(attacker);
        }
        else {
            epsilonWinning.updateWinningCount(attacker);
        }
        */
    }

    @Override
    public Player detemineWinningPlayer(WinnerStrategyContext context) {
            if(context.getRoundCount() <= 20){
                currentState = betaWinning;
            }

        if(context.getRoundCount() > 20){
            currentState = epsilonWinning;
        }
        return currentState.detemineWinningPlayer(context);

    }

}