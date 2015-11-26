package hotciv.standard;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import hotciv.framework.Die;

import java.util.Random;

public class DiceImpl implements Die {
    public int roll(){
        Random r = new Random();
        int d = r.nextInt(6)+1;
        return d;
    }
}
