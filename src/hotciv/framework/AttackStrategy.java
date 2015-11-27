package hotciv.framework;

import hotciv.standard.GameImpl;

public interface AttackStrategy {

    boolean battleResult(GameImpl game, Position attacker, Position defender);
}
