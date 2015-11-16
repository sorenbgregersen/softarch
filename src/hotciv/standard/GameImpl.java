package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

/**
 * Skeleton implementation of HotCiv.
 * <p>
 * This source code is from the book
 * "Flexible, Reliable Software:
 * Using Patterns and Agile Development"
 * published 2010 by CRC Press.
 * Author:
 * Henrik B Christensen
 * Department of Computer Science
 * Aarhus University
 * <p>
 * Please visit http://www.baerbak.com/ for further information.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class GameImpl implements Game {
    public CityImpl city1;
    public CityImpl city2;
    public TileImpl tile1_0;
    public TileImpl tile0_1;
    public TileImpl tile2_2;
    public TileImpl plains;
    public Player playerInTurn;
    public UnitImpl redArcher;
    public UnitImpl blueLegion;
    public UnitImpl redSettler;
    public int gameAge;
    public HashMap<Position, Unit> unitMap;


    public GameImpl(){
        city1 = new CityImpl(Player.RED);
        city2 = new CityImpl(Player.BLUE);
        tile1_0 = new TileImpl(GameConstants.OCEANS);
        tile0_1 = new TileImpl(GameConstants.HILLS);
        tile2_2 = new TileImpl(GameConstants.MOUNTAINS);
        plains = new TileImpl(GameConstants.PLAINS);
        playerInTurn = Player.RED;
        redArcher = new UnitImpl(GameConstants.ARCHER, Player.RED);
        blueLegion = new UnitImpl(GameConstants.LEGION, Player.BLUE);
        redSettler = new UnitImpl(GameConstants.SETTLER, Player.RED);
        gameAge = -4000;
        unitMap = new HashMap<>();
        unitMap.put(new Position(2,0), redArcher);
        unitMap.put(new Position(3,2), blueLegion);
        unitMap.put(new Position(4,3), redSettler);
    }

    public Tile getTileAt(Position p) {

        if (p.equals(new Position(1, 0))) {
            return tile1_0;
        }

        if (p.equals(new Position(0, 1))) {
            return tile0_1;
        }

        if (p.equals(new Position(2, 2))) {
            return tile2_2;
        }
        return plains;

    }

    public Unit getUnitAt(Position p) {
        return unitMap.get(p);
    }

    public City getCityAt(Position p) {
        CityImpl res = null;
        if(p.equals(new Position(1,1))){
            res = city1;
        }
        else if (p.equals(new Position(4,1))) {
            res = city2;
        }
        return res;
    }

    public Player getPlayerInTurn() {

        return playerInTurn;
    }

    public Player getWinner() {
        return Player.RED;
    }

    public int getAge() {
        return gameAge;
    }

    public boolean moveUnit(Position from, Position to) {
        Unit u_from = unitMap.get(from);
        Unit u_to = unitMap.get(to);

        if (Math.abs(from.getColumn() - to.getColumn()) > Math.abs(1) || Math.abs(from.getRow() - to.getRow()) > Math.abs(1)) {


            if (getTileAt(to).getTypeString().equals(GameConstants.MOUNTAINS)) {
                return false;
            }

            //This one belongs to the test: redCannotMoveBluesUnit()
            else if (u_from.getOwner() != getPlayerInTurn()) {
                return false;
            } else if (unitMap.containsKey(to)) {
                if (!u_from.getOwner().equals(u_to.getOwner())) {
                    unitMap.remove(to);
                    unitMap.put(to, u_from);
                    return true;
                }
                return false;
            } else {
                unitMap.put(to, u_from);
                unitMap.remove(from);
            }

            return true;
        }
        return  false;
    }

    public void endOfTurn() {
        gameAge += 100;
        if (playerInTurn == Player.RED) {
            playerInTurn = Player.BLUE;
        } else if (playerInTurn == Player.BLUE) {
            playerInTurn = Player.RED;
        }
    }

    public void changeWorkForceFocusInCityAt(Position p, String balance) {
    }

    public void changeProductionInCityAt(Position p, String unitType) {
    }

    public void performUnitActionAt(Position p) {
    }
}
