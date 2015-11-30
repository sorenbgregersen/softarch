package hotciv.framework;


import hotciv.standard.GameImpl;

public interface WinningStrategy {
    void incrementWinningCount(Player from);

    Player detemineWinningPlayer (GameImpl game);

    // maybe in the future add a list of cities instead of just two
}
