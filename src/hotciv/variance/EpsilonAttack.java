package hotciv.variance;

import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.standard.DiceImpl;
import hotciv.standard.GameImpl;
import hotciv.standard.Utility;

// et eller andet sted i denne klasse skal vi deklarere, at vi bruger DieStrategy.
//Et andet sted skal vi så give den enten DiceImpl eller DiceStub med.
// Det er dog nok i TestEpsilon

public class EpsilonAttack implements AttackStrategy {
    private DieStrategy die1, die2;
    Player winner;
    public int redWinningCount;
    public int blueWinningCount;

    public EpsilonAttack (DieStrategy die1, DieStrategy die2){
        this.die1 = die1;
        this.die2 = die2;
    }

    public boolean battleResult(GameImpl game, Position attacker, Position defender) {
        int attackerFriendlySupport = Utility.getFriendlySupport(game, attacker, game.getUnitAt(attacker).getOwner());
        int attackerTerrainFactor = Utility.getTerrainFactor(game, attacker);

        int defenderFriendlySupport = Utility.getFriendlySupport(game, defender, game.getUnitAt(defender).getOwner());
        int defenderTerrainFactor = Utility.getTerrainFactor(game, defender);


        int attackStrength = game.getUnitAt(attacker).getAttackingStrength() + attackerFriendlySupport
                 +  attackerTerrainFactor;

        int defenderStrength = game.getUnitAt(defender).getAttackingStrength() +  defenderFriendlySupport
                +  defenderTerrainFactor;

        //System.out.print("Attack: " + attackStrength + " + " + die1.roll() + "\n");
        //System.out.print("Defense: " + defenderStrength + " + " + die2.roll() + "\n");
        /*
        winner = game.getUnitAt(attacker).getOwner();

        if(winner == Player.RED) {
            redWinningCount += 1;
        }
        if(winner == Player.BLUE) {
            blueWinningCount += 1;
        }
        */
        return attackStrength * die1.roll() > defenderStrength * die2.roll();
    }

}
