package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;

/**
 * Created by Søren on 02-11-2015.
 */
public class CityImpl implements City {
    public Player owner;

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
        return "6";
    }

    @Override
    public String getWorkforceFocus () {
        return null;
    }
}