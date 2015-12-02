package hotciv.variance.factories;

import hotciv.framework.WorldMapStrategy;
import hotciv.variance.DeltaMap;

public class DeltaCivFactory extends BasicCivFactory{

    private final String[] layout;

    public DeltaCivFactory(String[] layout){
        this.layout = layout;
    }
    @Override
    public WorldMapStrategy createMapStrategy() {
        return new DeltaMap(layout);
    }
}
