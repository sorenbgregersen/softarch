package hotciv.framework;

import java.util.Collection;

public interface WinnerStrategyContext {
    public int getAge();
    public Collection<Player> getOwners();
    public int getRoundCount();
}
