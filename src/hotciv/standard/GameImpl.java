package hotciv.standard;

import hotciv.framework.*;

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
    public UnitImpl unit2_0;
    public UnitImpl unit3_2;
    public UnitImpl unit4_3;
    public int gameAge;

    public GameImpl(){
        city1 = new CityImpl(Player.RED);
        city2 = new CityImpl(Player.BLUE);
        tile1_0 = new TileImpl("ocean");
        tile0_1 = new TileImpl("hills");
        tile2_2 = new TileImpl("mountain");
        plains = new TileImpl("plains");
        playerInTurn = Player.RED;
        unit2_0 = new UnitImpl("archer", Player.RED);
        unit3_2 = new UnitImpl("legion", Player.BLUE);
        unit4_3 = new UnitImpl("settler", Player.RED);
        gameAge = -4000;
    }

    public Tile getTileAt(Position p) {
        TileImpl res = null;
        for (int row = GameConstants.WORLDSIZE - 1; row >= 0; row--) {
            for (int column = GameConstants.WORLDSIZE - 1; column >= 0; column--) {
                if (!(p.equals(new Position(1, 0)) || p.equals(new Position(0, 1)) || p.equals(new Position(2, 2)))) {
                    res = plains;
                } else if (p.equals(new Position(1, 0))) {
                    res = tile1_0;
                } else if (p.equals(new Position(0, 1))) {
                    res = tile0_1;
                } else if (p.equals(new Position(2, 2))) {
                    res = tile2_2;
                }
            }
        }
        return res;
    }

    public Unit getUnitAt(Position p) {
        UnitImpl res = null;
        if(p.equals(new Position(2,0))){
            res = unit2_0;
        }
        else if (p.equals(new Position(3,2))){
            res = unit3_2;
        }
        else if (p.equals(new Position(4,3))){
            res = unit4_3;
        }
        return res;
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
        return false;
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
