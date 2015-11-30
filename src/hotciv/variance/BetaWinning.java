package hotciv.variance;


import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;

public class BetaWinning implements WinningStrategy {

    @Override
    public Player detemineWinningPlayer(GameImpl game) {
        Player res = null;
        for (CityImpl c : game.cityMap.values()) {
            if (res == null) {
                res = c.getOwner();
            } else {
                if (!c.getOwner().equals(res)) {
                    return null;
                }
            }
        }
        return res;
    }

    @Override
    public void incrementWinningCount(Player from) {

    }
}
