package hotciv.variance;

import hotciv.framework.AttackStrategy;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;

public class AlphaAttack implements AttackStrategy{
    @Override
    public boolean battleResult(GameImpl game, Position attacker, Position defender) {
        return true;
    }
}
