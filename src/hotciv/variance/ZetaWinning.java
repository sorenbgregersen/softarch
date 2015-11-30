package hotciv.variance;

import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;

public class ZetaWinning implements WinningStrategy {
    private WinningStrategy betaStrategy, epsilonWinning, currentState;

    public ZetaWinning(WinningStrategy betaStrategy, WinningStrategy epsilonWinning){
        this.betaStrategy = new BetaWinning();
        this.epsilonWinning = new EpsilonWinning();
        this.currentState = null;
    }

    @Override
    public Player detemineWinningPlayer(GameImpl game) {
        if(game.roundCounter <= 20){
            currentState = betaStrategy;
        }
        if(game.roundCounter > 20){
            currentState = epsilonWinning;
        }
        return currentState.detemineWinningPlayer(game);
    }

    @Override
    public void incrementWinningCount(Player from) {

    }
}
