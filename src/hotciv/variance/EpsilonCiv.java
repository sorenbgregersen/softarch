package hotciv.variance;

import hotciv.framework.AttackStrategy;
import hotciv.framework.Die;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;
import hotciv.standard.Utility;

import java.util.Random;

/**
 * Created by Alex on 25-11-2015.
 */
public class EpsilonCiv implements AttackStrategy {
    @Override
    public boolean battleResult(GameImpl game, Position attacker, Position defender) {
        int attackerFriendlySupport = Utility.getFriendlySupport(game, attacker, game.getUnitAt(attacker).getOwner());
        int attackerTerrainFactor = Utility.getTerrainFactor(game, attacker);
        Dice d1 = new Dice();
        int defenderFriendlySupport = Utility.getFriendlySupport(game, defender, game.getUnitAt(defender).getOwner());
        int defenderTerrainFactor = Utility.getTerrainFactor(game, defender);
        double d2 = Math.floor(Math.random()*6)+1;

        int attackStrength = game.getUnitAt(attacker).getAttackingStrength() * attackerFriendlySupport
                 * attackerTerrainFactor;

        int defenderStrength = game.getUnitAt(defender).getAttackingStrength() * defenderFriendlySupport
                * defenderTerrainFactor;

        return attackStrength * d1 > defenderStrength * d2;

    }
}
