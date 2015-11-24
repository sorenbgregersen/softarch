package hotciv.variance;

import hotciv.framework.*;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;


public class GammaUnitActions implements UnitActionStrategy {
    @Override
    public void performUnitAction(GameImpl game, Position p) {
        CityImpl city = new CityImpl(game.getUnitAt(p).getOwner());
        if(game.getUnitAt(p).getTypeString() == GameConstants.SETTLER){
            game.unitMap.remove(p);
            game.cityMap.put(p, city);
        }
        else if(game.getUnitAt(p).getTypeString() == GameConstants.ARCHER) {
            game.getUnitAt(p).fortify();
        }
    }
}
