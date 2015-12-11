package hotciv.standard;

import hotciv.variance.factories.FractalMapFactory;
import thirdparty.ThirdPartyFractalGenerator;

public class TestFractalMap {
    private static Object layout;
    /*
    Creates DeltaCiv which is identical to AlphaCiv except it implements
    a different map, here called deltaMap, which refers to the variance class
    called DeltaMap
    */


    public static void main(String[] args) {
        GameImpl game = new GameImpl(new FractalMapFactory());
        ThirdPartyFractalGenerator generator =
                new ThirdPartyFractalGenerator();
        String line;
        System.out.println("Demonstration of the fractal map generator");
        for ( int r = 0; r < 16; r++ ) {
            line = "";
            for ( int c = 0; c < 16; c++ ) {
                line = line + generator.getLandscapeAt(r,c);
            }
            System.out.println( line );
        }
    }
}
