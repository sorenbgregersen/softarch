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
    public CityImpl city1 = new CityImpl(Player.RED);
    public TileImpl tile1_0 = new TileImpl("ocean");
    public Player playerInTurn = Player.RED;
    public UnitImpl unit2_0 = new UnitImpl();

    public Tile getTileAt(Position p) {
        return tile1_0;
    }

    public Unit getUnitAt(Position p) {
        return unit2_0;
    }

    public City getCityAt(Position p) {
        return city1;
    }

    public Player getPlayerInTurn() {

        return playerInTurn;
    }

    public Player getWinner() {
        return Player.RED;
    }

    public int getAge() {
        return 3000;
    }

    public boolean moveUnit(Position from, Position to) {
        return false;
    }

    public void endOfTurn() {
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
