package hotciv.standard;

import hotciv.framework.*;
import hotciv.variance.factories.AbstractFactory;

import java.util.ArrayList;
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
    public Player playerInTurn;
    public UnitImpl redArcher;
    public UnitImpl blueLegion;
    public UnitImpl redSettler;
    public int worldAge;
    public HashMap<Position, UnitImpl> unitMap;
    public HashMap<Position, CityImpl> cityMap;
    WorldAgingStrategy agingStrategy;
    WinningStrategy winningStrategy;
    UnitActionStrategy unitActionStrategy;
    WorldMapStrategy mapStrategy;
    AttackStrategy attackStrategy;
    public int roundCounter;

    public GameImpl(AbstractFactory factory){

        cityMap = new HashMap<>();
        city1 = new CityImpl(Player.RED);
        city2 = new CityImpl(Player.BLUE);
        cityMap.put(new Position(1, 1), city1);
        cityMap.put(new Position(4, 1), city2);
        playerInTurn = Player.RED;
        redArcher = new UnitImpl(GameConstants.ARCHER, Player.RED);
        blueLegion = new UnitImpl(GameConstants.LEGION, Player.BLUE);
        redSettler = new UnitImpl(GameConstants.SETTLER, Player.RED);
        worldAge = -4000;
        unitMap = new HashMap<>();
        unitMap.put(new Position(2,0), redArcher);
        unitMap.put(new Position(3,2), blueLegion);
        unitMap.put(new Position(4,3), redSettler);
        this.agingStrategy = factory.createAgingStrategy();
        this.winningStrategy = factory.createWinningStrategy();
        this.unitActionStrategy = factory.createUnitActionStrategy();
        this.mapStrategy = factory.createMapStrategy();
        this.attackStrategy = factory.createAttackStrategy();
    }



    public Tile getTileAt(Position p) {
        HashMap<Position, TileImpl> worldMap = mapStrategy.createWorldMap();
        return worldMap.get(p);
    }

    public UnitImpl getUnitAt(Position p) {
        return unitMap.get(p);
    }

    public CityImpl getCityAt(Position p) {
        return cityMap.get(p);
    }

    public Player getPlayerInTurn() {

        return playerInTurn;
    }

    public Player getWinner() {
        return winningStrategy.determineWinningPlayer(this);
    }

    public int getAge() {
        return worldAge;
    }

    public boolean moveUnit(Position from, Position to) {
        UnitImpl u_from = unitMap.get(from);
        UnitImpl u_to = unitMap.get(to);
        Player attacker = u_from.getOwner();
        boolean tileIsAMountain = getTileAt(to).getTypeString().equals(GameConstants.MOUNTAINS);
        boolean tileIsAnOcean = getTileAt(to).getTypeString().equals(GameConstants.OCEANS);

            // Units can not move over mountains and oceans
        if (tileIsAMountain || tileIsAnOcean)
            return false;

            //Unit can not be moved if it belongs to another player
        else if (attacker != getPlayerInTurn()) {
            return false;
        }
        else if (unitMap.containsKey(to)) {
            if (!attacker.equals(u_to.getOwner())) {
                if (attackStrategy.battleResult(this, from, to)) {
                    unitMap.remove(to);
                    unitMap.put(to, u_from);
                    winningStrategy.incrementWinningCount(this);
                    return true;
                }
            }
            return false;

        } else if (getCityAt(to) != null){
            if(getCityAt(to).getOwner() != u_from.getOwner()){
                getCityAt(to).changeOwnership(u_from.getOwner());
            }

        } else if ((Math.abs(from.getColumn() - to.getColumn()) > getUnitAt(from).getMoveCount()) ||
                (Math.abs(from.getRow() - to.getRow()) > getUnitAt(from).getMoveCount())) {
            return false;
        }

        else {
            unitMap.put(to, u_from);
            unitMap.remove(from);
        }

        return true;
    }

    public void endOfTurn() {
        if (playerInTurn == Player.RED) {
            playerInTurn = Player.BLUE;
        } else if (playerInTurn == Player.BLUE) {
            playerInTurn = Player.RED;
            endOfRound();
        }
    }

    public void endOfRound(){
        city1.increaseProductionTreasury(6);
        produceUnit(new Position(1, 1));
        city2.increaseProductionTreasury(6);
        produceUnit(new Position(4, 1));
        worldAge = agingStrategy.calculateWorldAge(worldAge);
        roundCounter += 1;
    }

    public void produceUnit(Position p) {
        int archerCost = 10;
        int legionCost = 15;
        int settlerCost = 30;

        if (getCityAt(p).getProduction() == GameConstants.ARCHER && getCityAt(p).getProductionTreasury() >= archerCost ) {
            placeUnit(p);
            getCityAt(p).decreaseProductionTreasury(archerCost);
        }
        /*
        if (getCityAt(p).getProduction() == GameConstants.LEGION && getCityAt(p).getProductionTreasury() >= legionCost) {
            placeUnit(p);
            getCityAt(p).decreaseProductionTreasury(legionCost);
        }
        if (getCityAt(p).getProduction() == GameConstants.SETTLER && getCityAt(p).getProductionTreasury() >= settlerCost) {
            placeUnit(p);
            getCityAt(p).decreaseProductionTreasury(settlerCost);
        }
        */
    }

    public void placeUnit(Position p) {
        UnitImpl newUnit = new UnitImpl(getCityAt(p).getProduction(), getCityAt(p).getOwner());
        ArrayList<Position> nearbyTiles = new ArrayList();
        int x = p.getRow();
        int y = p.getColumn();

        nearbyTiles.add(new Position(x, y));
        nearbyTiles.add(new Position(x-1, y));
        nearbyTiles.add(new Position(x-1, y+1));
        nearbyTiles.add(new Position(x, y+1));
        nearbyTiles.add(new Position(x+1, y+1));
        nearbyTiles.add(new Position(x+1, y));
        nearbyTiles.add(new Position(x+1, y-1));
        nearbyTiles.add(new Position(x, y-1));
        nearbyTiles.add(new Position(x-1, y-1));

        for(Position pos : nearbyTiles){
            if (!unitMap.containsKey(pos)){
                unitMap.put(pos, newUnit);
            }
        }
    }

    public int getRoundCounter(){
        return roundCounter;
    }

    public void changeWorkForceFocusInCityAt(Position p, String balance) {
    }

    public void changeProductionInCityAt(Position p, String unitType) {
    }

    public void performUnitActionAt(Position p) {
        unitActionStrategy.performUnitAction(this, p);
    }

}



