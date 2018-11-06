package control;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class LandControlTests {

    @Before
    public void setup() {
        GameControl.setRandomGenerator(new java.util.Random());
    }

    @Test
    public void testRandomPriceRange(){

        for (int i=0; i < 100; i++){
            LandControl.updateCurrentLandPrice();
            int price = LandControl.getCurrentLandPrice();
            assertTrue(price >= 17 && price <= 27);
        }
        
    }

    @Test
    public void testValuation(){
        LandControl.updateCurrentLandPrice();
        int price = LandControl.getCurrentLandPrice();
        int acres = 100;
        int valuation = acres * price;
        assertEquals(valuation, LandControl.getBushelsForLand(acres));
    }

    @Test
    public void testNegativeValation(){
        assertEquals(-1, LandControl.getBushelsForLand(-1));
    }
}