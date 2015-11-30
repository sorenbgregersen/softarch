package hotciv.variance;


import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.GameImpl;

public class AlphaWinning implements WinningStrategy {

    @Override
    public Player detemineWinningPlayer(GameImpl game) {
        return Player.RED;
    }

    @Override
    public void incrementWinningCount(Player from) {

    }
}
