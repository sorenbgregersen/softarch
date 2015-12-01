package hotciv.variance;


import hotciv.framework.Player;
import hotciv.framework.WinnerStrategyContext;
import hotciv.framework.WinningStrategy;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;

public class BetaWinning implements WinningStrategy {

    private int redWinningCount;
    private int blueWinningCount;

    @Override
    public void updateWinningCount(Player attacker) {
        if (attacker == Player.RED) {
            redWinningCount = 0;
        }
        if (attacker == Player.BLUE) {
            blueWinningCount = 0;
        }
    }

    @Override
    public Player detemineWinningPlayer(WinnerStrategyContext context) {
        Player res = null;
        for (Player owner : context.getOwners()) {
            if (res == null) {
                res = owner;
            }

            if (owner != res){
                    return null;
                }
            }

        return res;
    }
}
