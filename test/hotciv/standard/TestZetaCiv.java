package hotciv.standard;

import hotciv.framework.*;
import hotciv.variance.*;
import hotciv.variance.factories.AbstractFactory;
import hotciv.variance.factories.ZetaCivFactory;
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
        game = new GameImpl(new ZetaCivFactory(betaWinning, epsilonWinning));
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
    public void shouldReturnBlueAsWinnerWhenBlueHasWon3TimesAfter20Rounds(){
        ds1 = new DiceStub(dieValue1 = 6);
        ds2 = new DiceStub(dieValue2 = 1);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        zetaWinning = new ZetaWinning(betaWinning, epsilonWinning);
        game = new GameImpl(new AbstractFactory() {
            public WorldAgingStrategy createAgingStrategy() {
                return null;
            }
            public WinningStrategy createWinningStrategy() {
                return zetaWinning;
            }
            public UnitActionStrategy createUnitActionStrategy() {
                return null;
            }
            public WorldMapStrategy createMapStrategy() {
                return null;
            }
            public AttackStrategy createAttackStrategy() {
                return epsilonAttack;
            }
        });
        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);

        game.roundCounter = 23;
        assertThat("the game has altered 23 rounds", game.roundCounter, is(23));
        game.endOfTurn();
        //makes three successful attacks
        for(int i = 0 ; i < 4 ; i++) {
            zetaWinning.incrementWinningCount(game);
        }
        assertThat("Blue wins after 3 won battles",
                zetaWinning.determineWinningPlayer(game), is(Player.BLUE));
    }
    @Test
    public void ShouldNotWinOnAttacksBefore20Rounds(){
        ds1 = new DiceStub(dieValue1 = 6);
        ds2 = new DiceStub(dieValue2 = 1);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        zetaWinning = new ZetaWinning(betaWinning, epsilonWinning);
        game = new GameImpl(new AbstractFactory() {
            public WorldAgingStrategy createAgingStrategy() {
                return null;
            }
            public WinningStrategy createWinningStrategy() {
                return zetaWinning;
            }
            public UnitActionStrategy createUnitActionStrategy() {
                return null;
            }
            public WorldMapStrategy createMapStrategy() {
                return null;
            }
            public AttackStrategy createAttackStrategy() {
                return epsilonAttack;
            }
        });
        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);
        System.out.println("Round counter: " + game.roundCounter);
        //makes three successful attacks
        for(int i = 0 ; i < 4 ; i++) {
            zetaWinning.incrementWinningCount(game);
            assertThat("There is no winner due to attacks before 20 rounds", zetaWinning.determineWinningPlayer(game), is(nullValue()));
        }
    }
    @Test
    public void attacksMadeBefore20RoundsShouldNotInfluenceWinning() {
        ds1 = new DiceStub(dieValue1 = 6);
        ds2 = new DiceStub(dieValue2 = 1);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        zetaWinning = new ZetaWinning(betaWinning, epsilonWinning);
        game = new GameImpl(new AbstractFactory() {
            public WorldAgingStrategy createAgingStrategy() {
                return null;
            }
            public WinningStrategy createWinningStrategy() {
                return zetaWinning;
            }
            public UnitActionStrategy createUnitActionStrategy() {
                return null;
            }
            public WorldMapStrategy createMapStrategy() {
                return null;
            }
            public AttackStrategy createAttackStrategy() {
                return epsilonAttack;
            }
        });
        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);

        //makes three successful attacks
        for (int i = 0; i < 4; i++) {
            zetaWinning.incrementWinningCount(game);
        }
        //epsilonAttack.battleResult(game, attacker, defender); // necessary?
        for(int i = 0 ; i < 23 ; i++){
            game.endOfRound();
        }
        zetaWinning.incrementWinningCount(game);
        assertThat("There is no winner due to attacks before 20 rounds", zetaWinning.determineWinningPlayer(game), is(nullValue()));
    }
}