package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;


public class CityImpl implements City {
    public Player owner;
    public int productionTreasury = 6;

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
        return null;
    }

    public int getProductionTreasury () {
        return productionTreasury;
    }

    public void changeOwnership(Player owner) {
        this.owner = owner;
    }

    @Override
    public String getWorkforceFocus () {
        return null;
    }
}