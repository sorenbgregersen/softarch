package hotciv.framework;


import hotciv.standard.GameImpl;

public interface WinningStrategy {
    void updateWinningCount(Player attacker);

    Player detemineWinningPlayer(WinnerStrategyContext context);

    // maybe in the future add a list of cities instead of just two
}
