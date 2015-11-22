package hotciv.variance;


import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;

public class ConquerBasedWinning implements WinningStrategy {

    @Override
    public Player detemineWinningPlayer(City city1, City city2) {
        Player res = null;
        if (city1.getOwner() == city2.getOwner()) {
            res = city2.getOwner();
        }
        return res;
    }
}
