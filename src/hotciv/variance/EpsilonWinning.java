package hotciv.variance;

import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.GameImpl;

public class EpsilonWinning implements WinningStrategy {

    @Override
    public Player detemineWinningPlayer(GameImpl game) {

        if(game.redWinningCount >= 3){
            return Player.RED;
        }
        if(game.blueWinningCount >= 3){
            return Player.BLUE;
        }
        return null;
        }
}

