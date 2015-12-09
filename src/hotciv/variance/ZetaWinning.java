package hotciv.variance;

import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.GameImpl;

public class ZetaWinning implements WinningStrategy {
    private WinningStrategy
            betaWinning, epsilonWinning;

    public ZetaWinning (WinningStrategy betaWinning, WinningStrategy epsilonWinning){
        this.betaWinning = betaWinning;
        this.epsilonWinning = epsilonWinning;
    }

    @Override
    public void incrementWinningCount(GameImpl game) {
        if(game.getRoundCounter() < 20){
            betaWinning.incrementWinningCount(game);
        } if (game.getRoundCounter() > 20){
            epsilonWinning.incrementWinningCount(game);
        }
    }

    @Override
    public Player determineWinningPlayer(GameImpl game) {
        if(game.getRoundCounter() <= 20){
            return betaWinning.determineWinningPlayer(game);
        }
            return epsilonWinning.determineWinningPlayer(game);
    }
}
