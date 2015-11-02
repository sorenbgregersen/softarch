package hotciv.standard;

import hotciv.framework.Tile;

/**
 * Created by Søren on 02-11-2015.
 */
public class TileImpl implements Tile {
    public String type;

    public TileImpl(String _type) {
        this.type = _type;
    }

    @Override
    public String getTypeString() {
        return type;
    }
}
