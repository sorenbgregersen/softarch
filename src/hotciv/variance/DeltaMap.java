package hotciv.variance;

import hotciv.framework.Position;
import hotciv.framework.WorldMapStrategy;
import hotciv.standard.StringToTilemap;
import hotciv.standard.TileImpl;

import java.util.HashMap;

public class DeltaMap implements WorldMapStrategy {
    StringToTilemap mapGen = new StringToTilemap();

    @Override
    public HashMap<Position, TileImpl> createWorldMap() {
        String[] layout =
                new String[] {
                        "...ooMooooo.....",
                        "..ohhoooofffoo..",
                        ".oooooMooo...oo.",
                        ".ooMMMoooo..oooo",
                        "...ofooohhoooo..",
                        ".ofoofooooohhoo.",
                        "...ooo..........",
                        ".ooooo.ooohooM..",
                        ".ooooo.oohooof..",
                        "offfoooo.offoooo",
                        "oooooooo...ooooo",
                        ".ooMMMoooo......",
                        "..ooooooffoooo..",
                        "....ooooooooo...",
                        "..ooohhoo.......",
                        ".....ooooooooo..",
                };
    return mapGen.defineWorld(layout);
    }
}
