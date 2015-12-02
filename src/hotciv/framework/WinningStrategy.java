package hotciv.framework;


import hotciv.standard.GameImpl;

public interface WinningStrategy {
    void incrementWinningCount(GameImpl game);

    Player determineWinningPlayer(GameImpl game);

    // maybe in the future add a list of cities instead of just two
}
