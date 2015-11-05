package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Unit;

/**
 * Created by S�ren on 05-11-2015.
 */
public class UnitImpl implements Unit {
    @Override
    public String getTypeString() {
        return GameConstants.ARCHER;
    }

    @Override
    public Player getOwner() {
        return Player.RED;
    }

    @Override
    public int getMoveCount() {
        return 0;
    }

    @Override
    public int getDefensiveStrength() {
        return 0;
    }

    @Override
    public int getAttackingStrength() {
        return 0;
    }
}
