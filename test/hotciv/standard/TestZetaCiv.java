package hotciv.standard;

import hotciv.framework.DieStrategy;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinningStrategy;
import hotciv.variance.*;
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


    //This test tests that the BetaWinning strategy is used, when
    //the game lasts less than 20 rounds
    @Test
    public void shouldReturnRedAsWinnerIfGameLastsLessThan20Rounds() {
        game = new GameImpl(new LinearAging(), new ZetaWinning(betaWinning, epsilonWinning), new AlphaUnitActions(), new AlphaMap(), new AlphaAttack());
        game.moveUnit(new Position(4,3), new Position(4,2));
        game.endOfTurn();
        game.endOfTurn();
        game.moveUnit(new Position(4,2), new Position(4,1));
        assertThat("red wins when red conquers blue's city",
                game.getWinner(), is(Player.RED));
    }

    @Test
    public void shouldReturnRedAsWinnerWhenRedHasWon3Times(){
        dieValue1 = 6;
        dieValue2 = 1;
        ds1 = new DiceStub(dieValue1);
        ds2 = new DiceStub(dieValue2);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        zetaWinning = new ZetaWinning(betaWinning, epsilonWinning);
        game = new GameImpl(new LinearAging(), new EpsilonWinning(),
                new AlphaUnitActions(), new AlphaMap(), epsilonAttack);
        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);
        for(int i = 0 ; i < 20 ; i++){
            game.endOfRound();
        }
        System.out.println(game.roundCounter);
        epsilonAttack.battleResult(game, attacker, defender);
        zetaWinning.incrementWinningCount(Player.RED);
        epsilonAttack.battleResult(game, attacker, defender);
        zetaWinning.incrementWinningCount(Player.RED);
        epsilonAttack.battleResult(game, attacker, defender);
        zetaWinning.incrementWinningCount(Player.RED);
        assertThat("red wins after 3 won battles",
                zetaWinning.detemineWinningPlayer(game), is(Player.RED));
    }
}
