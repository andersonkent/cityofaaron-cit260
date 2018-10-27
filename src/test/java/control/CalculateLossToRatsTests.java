package control;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculateLossToRatsTests {

    @Test
    public void testInvalidWheat(){
        int loss = WheatControl.calculateLossToRats(10, -1);
        assertEquals("Should have failed validation", -1, loss);
    }

    @Test
    public void testInvalidTithes(){
        int loss = WheatControl.calculateLossToRats(-1, 0);
        assertEquals("Should have failed validation", -2, loss);

        loss = WheatControl.calculateHarvest(101, 0);
        assertEquals("Should have failed validation", -2, loss);
    }

    @Test
    public void testNoRats(){
        FakeRandom fakeRandom = new FakeRandom(30);
        GameControl.setRandomGenerator(fakeRandom);

        int loss = WheatControl.calculateLossToRats(10, 1000);
        assertEquals(0, loss);
    }

    @Test
    public void testLowTithing(){
        FakeRandom fakeRandom = new FakeRandom();
        fakeRandom.add(28); // chance of rats
        fakeRandom.add(1); 
        GameControl.setRandomGenerator(fakeRandom);

        int loss = WheatControl.calculateLossToRats(7, 1000);
        assertEquals(70, loss);
    }

    @Test
    public void testMidTithing(){
        FakeRandom fakeRandom = new FakeRandom();
        fakeRandom.add(28); // chance of rats
        fakeRandom.add(1); 
        GameControl.setRandomGenerator(fakeRandom);

        int loss = WheatControl.calculateLossToRats(10, 1000);
        assertEquals(40, loss);
    }


    @Test
    public void testHighTithing(){
        FakeRandom fakeRandom = new FakeRandom();
        fakeRandom.add(28); // chance of rats
        fakeRandom.add(1); 
        GameControl.setRandomGenerator(fakeRandom);

        int loss = WheatControl.calculateLossToRats(13, 1000);
        assertEquals(40, loss);
    }
}