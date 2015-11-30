package hotciv.variance;

import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.GameImpl;

public class ZetaWinning implements WinningStrategy {
    private WinningStrategy
            betaWinning, epsilonWinning, currentState;

    public ZetaWinning (WinningStrategy betaWinning, WinningStrategy epsilonWinning){
        this.betaWinning = betaWinning;
        this.epsilonWinning = epsilonWinning;
        this.currentState = null;
    }

    @Override
    public void incrementWinningCount(Player from) {
        epsilonWinning.incrementWinningCount(from);
    }

    @Override
    public Player detemineWinningPlayer(GameImpl game) {
        if(game.roundCounter <= 20){
            currentState = betaWinning;
        }
        if(game.roundCounter > 20){
            currentState = epsilonWinning;
        }
        return currentState.detemineWinningPlayer(game);
    }
}
