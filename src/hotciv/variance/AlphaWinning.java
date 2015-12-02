package hotciv.variance;


import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.GameImpl;

public class AlphaWinning implements WinningStrategy {
    private int winningAge = -3000;
    @Override
    public Player determineWinningPlayer(GameImpl game) {
        if(game.getAge() >= winningAge){
            return Player.RED;
        } else return null;
    }

    @Override
    public void incrementWinningCount(GameImpl game) {

    }
}
