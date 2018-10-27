package control;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculateMortalityTests {

    @Test
    public void testInvalidBushelsForFood(){
        int deathToll = PeopleControl.calculateMortality(-1, 2000);
        assertEquals("Should have failed validation", -1, deathToll);
    }

    @Test
    public void testInvalidPopulation(){
        int deathToll = PeopleControl.calculateMortality(500, -1);
        assertEquals("Should have failed validation", -2, deathToll);
    }

    @Test
    public void testBoundaryValues(){
        int deathToll = PeopleControl.calculateMortality(0, 0);
        assertEquals(0, deathToll);
    }

    @Test
    public void testPeopleFed(){
        int deathToll = PeopleControl.calculateMortality(10000, 300);
        assertEquals(0, deathToll);
    }

    @Test
    public void testPeopleStarved(){
        int deathToll = PeopleControl.calculateMortality(10000, 600);
        assertEquals(100, deathToll);
    }

}