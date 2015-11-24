package hotciv.standard;

import hotciv.framework.*;


public class CityImpl implements City {
    public Player owner;
    public int productionTreasury = 6;
    public String unitProduction;

    public CityImpl(Player _owner) {
        this.owner = _owner;
    }

    @Override
    public Player getOwner () {
        return owner;
    }

    @Override
    public int getSize () {
        return 1;
    }

    @Override
    public String getProduction () {
        return unitProduction;

    }

    public void setProduction(String unitType) {
        unitProduction = unitType;
    }

    public int getProductionTreasury () {
        return productionTreasury;
    }

    public void increaseProductionTreasury (int increaseValue) {
        this.productionTreasury += increaseValue;

    }


    public void decreaseProductionTreasury(int decreaseValue) {
        this.productionTreasury -= decreaseValue;
    }

    public void changeOwnership(Player owner) {
        this.owner = owner;
    }

    @Override
    public String getWorkforceFocus () {
        return null;
    }
}