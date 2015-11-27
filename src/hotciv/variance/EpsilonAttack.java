package hotciv.variance;

import hotciv.framework.AttackStrategy;
import hotciv.framework.DieStrategy;
import hotciv.framework.Position;
import hotciv.standard.DiceImpl;
import hotciv.standard.GameImpl;
import hotciv.standard.Utility;

// et eller andet sted i denne klasse skal vi deklarere, at vi bruger DieStrategy.
//Et andet sted skal vi så give den enten DiceImpl eller DiceStub med.
// Det er dog nok i TestEpsilon

public class EpsilonAttack implements AttackStrategy {
    private DieStrategy die;

    public EpsilonAttack (DieStrategy die){
        this.die = die;
    }

    @Override
    public boolean battleResult(GameImpl game, Position attacker, Position defender) {
        int attackerFriendlySupport = Utility.getFriendlySupport(game, attacker, game.getUnitAt(attacker).getOwner());
        int attackerTerrainFactor = Utility.getTerrainFactor(game, attacker);

        int defenderFriendlySupport = Utility.getFriendlySupport(game, defender, game.getUnitAt(defender).getOwner());
        int defenderTerrainFactor = Utility.getTerrainFactor(game, defender);

        int d1 = new die.roll();
        int d2 = new die.roll();

        int attackStrength = game.getUnitAt(attacker).getAttackingStrength() * attackerFriendlySupport
                 * attackerTerrainFactor;

        int defenderStrength = game.getUnitAt(defender).getAttackingStrength() * defenderFriendlySupport
                * defenderTerrainFactor;

        return attackStrength * d1 > defenderStrength * d2;
    }
}
