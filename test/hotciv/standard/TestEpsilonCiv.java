package hotciv.standard;

import hotciv.framework.*;

import hotciv.variance.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestEpsilonCiv {
    private GameImpl game;
    private EpsilonAttack epsilonAttack;
    private int dieValue1;
    private int dieValue2;
    private DieStrategy ds1;
    private DieStrategy ds2;
    /**
     * Fixture for epsilonciv testing.
     */
    @Before
    public void setUp() {

    }

    @Test
    public void archerShouldWinIfHeRollsSix(){
        dieValue1 = 6;
        dieValue2 = 1;
        ds1 = new DiceStub(dieValue1);
        ds2 = new DiceStub(dieValue2);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        game = new GameImpl(new LinearAging(), new AlphaWinning(),
                new AlphaUnitActions(), new AlphaMap(), epsilonAttack);

        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);

        assertTrue("Archer Should win with roll 6 over Legion roll 1",
                epsilonAttack.battleResult(game, attacker, defender));
    }

    @Test
    public void shouldReturnRedAsWinnerWhenRedHasWon3Times(){
        dieValue1 = 6;
        dieValue2 = 1;
        ds1 = new DiceStub(dieValue1);
        ds2 = new DiceStub(dieValue2);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        game = new GameImpl(new LinearAging(), new AlphaWinning(),
                new AlphaUnitActions(), new AlphaMap(), epsilonAttack);
        Position attacker = new Position(2, 0);
        Position defender = new Position(3, 2);
        epsilonAttack.battleResult(game, attacker, defender);
        epsilonAttack.battleResult(game, attacker, defender);
        epsilonAttack.battleResult(game, attacker, defender);
        assertThat("red wins after 3 won battles",
                game.getWinner(), is(Player.RED));
    }
}
