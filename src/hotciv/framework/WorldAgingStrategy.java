package hotciv.framework;

/**
 * Created by Alex on 18-11-2015.
 */


/**
 Return the ageing strategy used in the different versions of hotciv
 */
public interface WorldAgingStrategy {
    public int calculateWorldAge(int worldAge);
}
