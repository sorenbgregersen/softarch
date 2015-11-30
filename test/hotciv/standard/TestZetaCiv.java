package hotciv.standard;

import hotciv.framework.DieStrategy;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.variance.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class TestZetaCiv {
    private GameImpl game;
    private EpsilonAttack epsilonAttack;
    private ZetaWinning zetaWinning;
    private BetaWinning betaWinning = new BetaWinning();
    private EpsilonWinning epsilonWinning = new EpsilonWinning();
    private int dieValue1;
    private int dieValue2;
    private DieStrategy ds1;
    private DieStrategy ds2;

    @Before
    public void setUp(){
        game = new GameImpl(new AlphaAging(), new ZetaWinning(betaWinning, epsilonWinning),
                new AlphaUnitActions(), new AlphaMap(), new AlphaAttack());
    }

    //This test tests that the BetaWinning strategy is used, when
    //the game lasts less than 20 rounds
    //This test is a unit test
    @Test
    public void shouldReturnRedAsWinnerIfGameLastsLessThan20Rounds() {
        game.moveUnit(new Position(4,3), new Position(4,2));
        game.endOfTurn();
        game.endOfTurn();
        game.moveUnit(new Position(4,2), new Position(4,1));
        assertThat("red wins when red conquers blue's city",
                game.getWinner(), is(Player.RED));
    }

    //This test tests that EpsilonWinning is used, when the
    //game lasts more than 20 rounds. In order to check, that
    //red wins, 23 rounds are played since it takes red 3 rounds
    //to win 3 attacks.
    //This test is a unit test
    @Test
    public void shouldReturnRedAsWinnerWhenRedHasWon3Times(){
        ds1 = new DiceStub(dieValue1 = 6);
        ds2 = new DiceStub(dieValue2 = 1);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        zetaWinning = new ZetaWinning(betaWinning, epsilonWinning);
        game = new GameImpl(new AlphaAging(), new EpsilonWinning(),
                new AlphaUnitActions(), new AlphaMap(), epsilonAttack);
        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);

        //calling endRound in game 23 times in order to increase roundCounter
        //to over 20 and reach the EpsilonCiv strategy.
        for(int i = 0 ; i < 23 ; i++){
            game.endOfRound();
        }
        //c
        for(int i = 0 ; i < 4 ; i++) {
            epsilonAttack.battleResult(game, attacker, defender);
            zetaWinning.incrementWinningCount(Player.RED);
        }
        assertThat("red wins after 3 won battles",
                zetaWinning.detemineWinningPlayer(game), is(Player.RED));
    }
}
