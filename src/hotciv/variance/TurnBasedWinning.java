package hotciv.variance;


import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;

public class TurnBasedWinning implements WinningStrategy {

    @Override
    public Player detemineWinningPlayer(City city1, City city2) {
        return Player.RED;
    }
}
