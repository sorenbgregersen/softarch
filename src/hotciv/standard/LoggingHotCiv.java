package hotciv.standard;

import hotciv.framework.*;

public class LoggingHotCiv implements Game {
    private GameImpl game;

    public LoggingHotCiv(GameImpl game){
        this.game = game;
    }

    @Override
    public Tile getTileAt(Position p) {
        return game.getTileAt(p);
    }

    @Override
    public Unit getUnitAt(Position p) {
        return game.getUnitAt(p);
    }

    @Override
    public City getCityAt(Position p) {
        return game.getCityAt(p);
    }

    @Override
    public Player getPlayerInTurn() {
        return game.getPlayerInTurn();
    }

    @Override
    public Player getWinner() {
        return game.getWinner();
    }

    @Override
    public int getAge() {
        return game.getAge();
    }

    @Override
    public int getRoundCounter() {
        return game.roundCounter;
    }

    @Override
    public boolean moveUnit(Position from, Position to) {
        System.out.println(game.getPlayerInTurn() + " " + game.getUnitAt(from).getTypeString() +
                " has moved from position " + from + " to position " + to);
        return game.moveUnit(from, to);
    }

    @Override
    public void endOfTurn() {
        game.endOfTurn();
    }

    @Override
    public void changeWorkForceFocusInCityAt(Position p, String balance) {
    }

    @Override
    public void changeProductionInCityAt(Position p, String unitType) {

    }

    @Override
    public void performUnitActionAt(Position p) {
        game.performUnitActionAt(p);

    }
}
