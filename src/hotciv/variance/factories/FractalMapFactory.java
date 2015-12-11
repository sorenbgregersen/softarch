package hotciv.variance.factories;

import hotciv.framework.WorldMapStrategy;
import hotciv.variance.DeltaMap;
import hotciv.variance.MapAdapter;

public class FractalMapFactory extends BasicCivFactory {

    @Override
    public WorldMapStrategy createMapStrategy() {
        return new MapAdapter();
    }
}
