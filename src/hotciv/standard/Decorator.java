package hotciv.standard;

import hotciv.framework.*;
import hotciv.variance.LogDecorator;


// gameimpl decorator that logs all activities
public class Decorator implements Game {
    protected Game decoratedGame;

    public Decorator(Game decoratedGame){
        this.decoratedGame = decoratedGame;
    }
/*
    if (game == decoratee) {
        decoratee = game;
        game = new LogDecorator(game);
    } else {
        game = decoratee;
    }
*/

    @Override
    public Tile getTileAt(Position p) {
        return decoratedGame.getTileAt(p);
    }

    @Override
    public Unit getUnitAt(Position p) {
        return decoratedGame.getUnitAt(p);
    }

    @Override
    public City getCityAt(Position p) {
        return decoratedGame.getCityAt(p);
    }

    @Override
    public Player getPlayerInTurn() {
        return decoratedGame.getPlayerInTurn();
    }

    @Override
    public Player getWinner() {
        return decoratedGame.getWinner();
    }

    @Override
    public int getAge() {
        return decoratedGame.getAge();
    }

    @Override
    public int getRoundCounter() {
        return 0;
        //game.roundCounter;
    }

    @Override
    public boolean moveUnit(Position from, Position to) {
        System.out.println(decoratedGame.getPlayerInTurn() + " " + decoratedGame.getUnitAt(from).getTypeString() +
                " has moved from position " + from + " to position " + to);
        return decoratedGame.moveUnit(from, to);
    }

    @Override
    public void endOfTurn() {
        decoratedGame.endOfTurn();
    }

    @Override
    public void changeWorkForceFocusInCityAt(Position p, String balance) {
    }

    @Override
    public void changeProductionInCityAt(Position p, String unitType) {

    }

    @Override
    public void performUnitActionAt(Position p) {
        decoratedGame.performUnitActionAt(p);

    }
}
