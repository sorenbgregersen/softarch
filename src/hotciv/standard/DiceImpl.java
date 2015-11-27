package hotciv.standard;

import hotciv.framework.DieStrategy;

import java.util.Random;

public class DiceImpl implements DieStrategy {
    public int roll(){
        Random r = new Random();
        int d = r.nextInt(6)+1;
        return d;
    }
}
