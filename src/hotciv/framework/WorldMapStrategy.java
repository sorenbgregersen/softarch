package hotciv.framework;

import hotciv.standard.TileImpl;

import java.util.HashMap;

public interface WorldMapStrategy {
    HashMap<Position, TileImpl> createWorldMap();
}
