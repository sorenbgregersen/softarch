package hotciv.standard;


import hotciv.variance.MapAdapter;
import hotciv.variance.factories.DeltaCivFactory;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class TestFractalMap {
    /*
    Creates DeltaCiv which is identical to AlphaCiv except it implements
    a different map, here called deltaMap, which refers to the variance class
    called DeltaMap
    */

    @Test
    public void shouldUseFractalMap(){
        MapAdapter mapGenerator = new MapAdapter();
        System.out.println(mapGenerator.createWorldMap());
        assertThat("uses fractal map to generate map", mapGenerator.createWorldMap(), is(notNullValue()));
    }
}
