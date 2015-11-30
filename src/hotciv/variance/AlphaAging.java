package hotciv.variance;

import hotciv.framework.WorldAgingStrategy;

/**
 * Created by Alex on 18-11-2015.
 */
public class AlphaAging implements WorldAgingStrategy{


    @Override
    public int calculateWorldAge(int worldAge) {
        return worldAge+100;
    }
}
