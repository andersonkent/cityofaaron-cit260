package control;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculateHarvestTests {

    @Test
    public void testInvalidAcres(){
        int harvest = WheatControl.calculateHarvest(10, -1);
        assertEquals("Should have failed validation", -1, harvest);
    }

    @Test
    public void testInvalidTithes(){
        int harvest = WheatControl.calculateHarvest(-1, 0);
        assertEquals("Should have failed validation", -2, harvest);

        harvest = WheatControl.calculateHarvest(101, 0);
        assertEquals("Should have failed validation", -2, harvest);
    }

    @Test
    public void testLowTithing(){
        FakeRandom fakeRandom = new FakeRandom(1);
        GameControl.setRandomGenerator(fakeRandom);

        int harvest = WheatControl.calculateHarvest(7, 1000);
        assertEquals(2000, harvest);
    }

    @Test
    public void testMidTithing(){
        FakeRandom fakeRandom = new FakeRandom(1);
        GameControl.setRandomGenerator(fakeRandom);
        
        int harvest = WheatControl.calculateHarvest(10, 1000);
        assertEquals(3000, harvest);
    }


    @Test
    public void testHighTithing(){
        FakeRandom fakeRandom = new FakeRandom(1);
        GameControl.setRandomGenerator(fakeRandom);
        
        int harvest = WheatControl.calculateHarvest(13, 1000);
        assertEquals(3000, harvest);
    }
}