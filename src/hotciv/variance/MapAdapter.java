package hotciv.variance;

import hotciv.framework.Position;
import hotciv.framework.WorldMapStrategy;
import hotciv.standard.StringToTilemap;
import hotciv.standard.TileImpl;
import thirdparty.ThirdPartyFractalGenerator;

import java.util.HashMap;

public class MapAdapter implements WorldMapStrategy {
    private ThirdPartyFractalGenerator generator;
    private StringToTilemap stringToTilemap;

    public MapAdapter() {
        generator = new ThirdPartyFractalGenerator();
        stringToTilemap = new StringToTilemap();
    }

    @Override
    public HashMap<Position, TileImpl> createWorldMap() {
        ThirdPartyFractalGenerator generator =
                new ThirdPartyFractalGenerator();
        String line;
        String[] layout = new String[16];
        for (int r = 0; r < 16; r++) {
            line = "";
            for (int c = 0; c < 16; c++) {
                line = line + generator.getLandscapeAt(r, c);
            }
            layout[r] = line;
        }
        return stringToTilemap.defineWorld(layout);
    }
}
