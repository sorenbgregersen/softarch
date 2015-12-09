package hotciv.variance;

import hotciv.framework.*;
import hotciv.standard.GameImpl;

public class EpsilonWinning implements WinningStrategy {
    public int redWinningCount;
    public int blueWinningCount;

    @Override
    public void incrementWinningCount(GameImpl game) {
        if (game.getPlayerInTurn() == Player.RED) {
            redWinningCount++;
        }
        if (game.getPlayerInTurn() == Player.BLUE) {
            blueWinningCount++;
        }
    }

    @Override
    public Player determineWinningPlayer(GameImpl game) {
        if (redWinningCount >= 3){
            return Player.RED;
        }
        if (blueWinningCount >= 3){
            return Player.BLUE;
        }
        return null;
        }
    }

