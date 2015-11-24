package hotciv.framework;

/**
 Return the ageing strategy used in the different versions of hotciv
 */
public interface WorldAgingStrategy {
   int calculateWorldAge(int worldAge);
}
