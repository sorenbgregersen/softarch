package hotciv.framework;

import hotciv.framework.*;
import hotciv.standard.CityImpl;

import java.util.HashMap;

public interface GameContext {
    public Tile getTileAt(Position p ) ;
    public Unit getUnitAt(Position p );
    public City getCityAt(Position p );
    public Player getPlayerInTurn();
    public Player getWinner();
    public int getAge();
    public int getRoundCounter();
    //public HashMap<Player, CityImpl> getCities();
}
