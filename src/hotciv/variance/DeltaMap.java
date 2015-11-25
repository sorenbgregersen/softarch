package hotciv.variance;

import hotciv.framework.Position;
import hotciv.framework.WorldMapStrategy;
import hotciv.standard.StringToTilemap;
import hotciv.standard.TileImpl;

import java.awt.font.LayoutPath;
import java.util.HashMap;

public class DeltaMap implements WorldMapStrategy {
    private StringToTilemap mapGen = new StringToTilemap();
    private String[] layout;

    public DeltaMap(String[] layout) {
        this.layout = layout;
    }

    @Override
    public HashMap<Position, TileImpl> createWorldMap() {
        //String[] layout = layout;
        return mapGen.defineWorld(this.layout);
    }
}

