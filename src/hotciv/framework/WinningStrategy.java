package hotciv.framework;


public interface WinningStrategy {
    Player detemineWinningPlayer (City city1, City city2);
    // maybe in the future add a list of cities instead of just two
}
