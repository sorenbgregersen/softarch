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

    public void setProduction(String gameConstants) {
        this.unitProduction = gameConstants;
    }

    public int getProductionTreasury () {
        return productionTreasury;
    }

    public void incrementProductionTreasury() {
        productionTreasury += 6;
    }

    public void changeOwnership(Player owner) {
        this.owner = owner;
    }

    @Override
    public String getWorkforceFocus () {
        return null;
    }
}