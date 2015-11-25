package hotciv.standard;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import hotciv.framework.Die;

import java.util.Random;

/**
 * Created by Alex on 25-11-2015.
 */
public class Dice implements Die {
    public int roll(){
        Random r = new Random();
        int d = r.nextInt(6)+1;
        return d;
    }
}
