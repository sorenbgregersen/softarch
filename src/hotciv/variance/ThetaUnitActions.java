package hotciv.variance;

import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.UnitActionStrategy;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;

public class ThetaUnitActions implements UnitActionStrategy{
    @Override
    public void performUnitAction(GameImpl game, Position p) {
        if(game.getUnitAt(p).getTypeString() == GameConstants.SETTLER){
            CityImpl city = new CityImpl(game.getUnitAt(p).getOwner());
            game.unitMap.remove(p);
            game.cityMap.put(p, city);
        }
        if(game.getUnitAt(p).getTypeString() == GameConstants.ARCHER) {
            game.getUnitAt(p).fortify();
        }
        if(game.getUnitAt(p).getTypeString() == ThetaCiv.CHARIOT) {
            game.getUnitAt(p).fortify();
        }
    }
}
