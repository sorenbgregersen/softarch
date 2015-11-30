package hotciv.variance;

import hotciv.framework.*;
import hotciv.standard.GameImpl;

public class EpsilonWinning implements WinningStrategy {
    public int redWinningCount;
    public int blueWinningCount;

    @Override
    public void incrementWinningCount(Player attacker) {
        if (attacker == Player.RED) {
            redWinningCount += 1;
        }
        if (attacker == Player.BLUE) {
            blueWinningCount += 1;
        }
    }

    @Override
    public Player detemineWinningPlayer(GameImpl game) {
        if (redWinningCount >= 3){
            return Player.RED;
        }
        if (blueWinningCount >= 3){
            return Player.BLUE;
        }
        return null;
        }
    }

