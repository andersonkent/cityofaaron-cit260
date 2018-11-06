package control;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculateNewMoveInsTests {


    @Test
    public void testNewMoveIns(){

        GameControl.setRandomGenerator(new java.util.Random());

        for (int i=0; i < 100; i++){
            int newMoveIns = PeopleControl.calculateNewMoveIns(1000);
            assertTrue(newMoveIns >= 10 && newMoveIns <= 50);
        }
    }

    @Test
    public void testNegativePopulation(){
        int newMoveIns = PeopleControl.calculateNewMoveIns(-1);
        assertEquals(-1, newMoveIns);
    }
}