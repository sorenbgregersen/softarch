package hotciv.variance.factories;

import hotciv.framework.UnitActionStrategy;
import hotciv.variance.GammaUnitActions;

public class GammaCivFactory extends BasicCivFactory {
    @Override
    public UnitActionStrategy createUnitActionStrategy() {
        return new GammaUnitActions();
    }

}
