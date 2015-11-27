package hotciv.standard;

import hotciv.framework.*;

import hotciv.variance.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestEpsilonCiv {
    private GameImpl game;
    private EpsilonAttack epsilonAttack;
    private DiceStub diceStub;

    /**
     * Fixture for epsilonciv testing.
     */
    @Before
    public void setUp() {
        epsilonAttack = new EpsilonAttack(diceStub);
        game = new GameImpl(new LinearAging(), new TurnBasedWinning(),
                new AlphaUnitActions(), new AlphaMap(), new EpsilonAttack(diceStub));
    }

    @Test
    public void archerShouldWinIfHeRollsSix(){
        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);
        /* Should be unnessesary if making a unit test
        //move the red archer closer to the blue legion
        game.moveUnit(new Position(2, 0), new Position(3, 1));
        game.endOfTurn();
        game.endOfTurn();
        */
        assertTrue("should return true if archer rolls six and legend rolls 1",
                epsilonAttack.battleResult(game, attacker, defender));
    }
}
