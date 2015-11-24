package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;

/**
 * Created by S�ren on 05-11-2015.
 */
public class UnitImpl implements Unit {
    public String type;
    public Player owner;
    public boolean isFortified = false;
    public int moveCount = 1;
    private int defensiveStrength = 3;

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
        return moveCount;
    }

    public void setMoveCount(int move){
      moveCount = move;
    }

    @Override
    public int getDefensiveStrength() {
        return defensiveStrength;
    }

    public void fortify(){

        if (!isFortified) {
            setMoveCount(0);
            defensiveStrength = defensiveStrength*2;
            isFortified = true;
        }
        else{
            setMoveCount(1);
            defensiveStrength = defensiveStrength/2;
            isFortified = false;
        }
    }

    @Override
    public int getAttackingStrength() {
        return 0;
    }
}
