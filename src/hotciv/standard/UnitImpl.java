package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import hotciv.variance.ThetaCiv;

public class UnitImpl implements Unit {
    public String type;
    public Player owner;
    public boolean isFortified = false;
    public int moveCount = 1;
    private int defensiveStrength = 0;
    private int attackStrength = 0;

    public UnitImpl(String type, Player owner) {
        this.type = type;
        this.owner = owner;

        if(type == GameConstants.ARCHER){
            defensiveStrength = 3;
            attackStrength = 2;
        }

        if(type == GameConstants.LEGION) {
            defensiveStrength = 2;
            attackStrength = 4;
        }

        if(type == GameConstants.SETTLER) {
            defensiveStrength = 3;
            attackStrength = 0;
        }

        if(type == ThetaCiv.CHARIOT) {
            defensiveStrength = 1;
            attackStrength = 3;
        }
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

        if(type == GameConstants.ARCHER || type == ThetaCiv.CHARIOT) {
            if (!isFortified) {
                setMoveCount(0);
                defensiveStrength = defensiveStrength * 2;
                isFortified = true;
            } else {
                setMoveCount(1);
                defensiveStrength = defensiveStrength / 2;
                isFortified = false;
            }
        }
    }

    @Override
    public int getAttackingStrength() {
        return attackStrength;
    }
}
