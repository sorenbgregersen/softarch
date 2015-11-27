package hotciv.standard;

import hotciv.framework.DieStrategy;

public class DiceStub implements DieStrategy {
    int dieRoll;

        public DiceStub (int dieRoll){
            this.dieRoll = dieRoll;
    }

    @Override
    public int roll() {
        return dieRoll;
    }
}
