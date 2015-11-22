package hotciv.variance;

import hotciv.framework.WorldAgingStrategy;


public class ProgressiveAgeing implements WorldAgingStrategy {
    @Override
    public int calculateWorldAge(int worldAge) {
        int res = worldAge;

        if (worldAge < -100) {
            res = worldAge + 100;
        }
        if (worldAge == -100){
            res = worldAge +99;
        }
        if (worldAge == -1){
            res = worldAge +2;
        }
        if (worldAge == 1){
            res = worldAge +49;
        }
        if (worldAge >= 50 && worldAge< 1750 ) {
            res = worldAge + 50;
        }
        if (worldAge >= 1750 && worldAge < 1900) {
            res = worldAge + 25;
        }
        if (worldAge >= 1900 && worldAge < 1970) {
            res = worldAge + 5;
        }
        if (worldAge >= 1970) {
            res = worldAge + 1;
        }
    return res;
    }
}