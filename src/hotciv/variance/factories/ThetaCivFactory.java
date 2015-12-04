package hotciv.variance.factories;

import hotciv.framework.UnitActionStrategy;
import hotciv.variance.ThetaUnitActions;

public class ThetaCivFactory extends GammaCivFactory {

    @Override
    public UnitActionStrategy createUnitActionStrategy() {
        return new ThetaUnitActions();
    }
}
