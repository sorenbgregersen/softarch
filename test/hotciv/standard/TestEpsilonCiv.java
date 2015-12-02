package hotciv.standard;

import hotciv.framework.*;

import hotciv.variance.*;
import hotciv.variance.factories.AbstractFactory;
import hotciv.variance.factories.EpsilonCivFactory;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestEpsilonCiv {
    private GameImpl game;
    private EpsilonAttack epsilonAttack;
    private EpsilonWinning epsilonWinning;
    private int dieValue1;
    private int dieValue2;
    private DieStrategy ds1;
    private DieStrategy ds2;
    /**
     * Fixture for epsilonciv testing.
     */

    @Test
    public void archerShouldWinIfHeRollsSix(){
        dieValue1 = 6;
        dieValue2 = 1;
        ds1 = new DiceStub(dieValue1);
        ds2 = new DiceStub(dieValue2);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        game = new GameImpl(new AbstractFactory() {
            public WorldAgingStrategy createAgingStrategy() {
                return null;
            }
            public WinningStrategy createWinningStrategy() {
                return epsilonWinning;
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
        epsilonWinning = new EpsilonWinning();
        game = new GameImpl(new AbstractFactory() {
            public WorldAgingStrategy createAgingStrategy() {
                return null;
            }
            public WinningStrategy createWinningStrategy() {
                return epsilonWinning;
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
        for(int i = 0 ; i < 4 ; i++) {
            epsilonAttack.battleResult(game, attacker, defender);
            epsilonWinning.incrementWinningCount(game);
        }
        assertThat("red wins after 3 won battles",
                epsilonWinning.determineWinningPlayer(game), is(Player.RED));
    }

    @Test
    public void shouldReturnBlueAsWinnerWhenBlueHasWon3Times(){
        dieValue1 = 6;
        dieValue2 = 1;
        ds1 = new DiceStub(dieValue1);
        ds2 = new DiceStub(dieValue2);
        epsilonAttack = new EpsilonAttack(ds1, ds2);
        epsilonWinning = new EpsilonWinning();
        game = new GameImpl(new AbstractFactory() {
            public WorldAgingStrategy createAgingStrategy() {
                return null;
            }
            public WinningStrategy createWinningStrategy() {
                return epsilonWinning;
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

        Position attacker = new Position(3, 2);
        Position defender = new Position(2, 0);
        game.endOfTurn();
        for(int i = 0 ; i < 4 ; i++) {
            epsilonAttack.battleResult(game, attacker, defender);
            epsilonWinning.incrementWinningCount(game);
        }
        assertThat("blue wins after 3 won battles",
                epsilonWinning.determineWinningPlayer(game), is(Player.BLUE));
    }

}
