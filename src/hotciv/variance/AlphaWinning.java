package hotciv.variance;


import hotciv.framework.Player;
import hotciv.framework.WinnerStrategyContext;
import hotciv.framework.WinningStrategy;
import hotciv.standard.GameImpl;

public class AlphaWinning implements WinningStrategy {
    private int winningAge = -3000;
    private int redWinningCount;
    private int blueWinningCount;

    @Override
    public void updateWinningCount(Player attacker) {
    }


    @Override
    public Player detemineWinningPlayer(WinnerStrategyContext context) {
        if (context.getAge() >= winningAge){
            return Player.RED;
        } else return null;
    }
}
