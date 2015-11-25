package hotciv.framework;

import hotciv.standard.GameImpl;

/**
 * Created by Alex on 25-11-2015.
 */
public interface AttackStrategy {

    boolean battleResult(GameImpl game, Position attacker, Position defender);
}
