package hotciv.variance;

import hotciv.framework.Position;
import hotciv.framework.WorldMapStrategy;
import hotciv.standard.StringToTilemap;
import hotciv.standard.TileImpl;

import java.util.HashMap;

public class AlphaMap implements WorldMapStrategy {
    StringToTilemap mapGen = new StringToTilemap();
    @Override
    public HashMap<Position, TileImpl> createWorldMap() {
        String[] layout =
                new String[] {
                        "ohoooooooooooooo",
                        ".ooooooooooooooo",
                        "ooMooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                        "oooooooooooooooo",
                };
        return mapGen.defineWorld(layout);
    }
}
