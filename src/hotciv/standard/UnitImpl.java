package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Unit;

/**
 * Created by Søren on 05-11-2015.
 */
public class UnitImpl implements Unit {
    public String type;
    public Player owner;

    public UnitImpl(String _type, Player _owner) {
        this.type = _type;
        this.owner = _owner;
    }

    @Override
    public String getTypeString() {
        return type;
    }

    @Override
    public Player getOwner() {
        return owner;
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
