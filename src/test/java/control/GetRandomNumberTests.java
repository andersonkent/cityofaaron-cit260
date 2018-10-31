package control;

import org.junit.Test;
import static org.junit.Assert.*;

public class GetRandomNumberTests {

    @Test
    public void inputsNotNegativeTest(){
        int random = GameControl.getRandomNumber(-1, 10);
        assertEquals(-1, random);
        
        random = GameControl.getRandomNumber(10, -1);
        assertEquals(-1, random);
    }

    @Test
    public void inputOrderTest(){
        int random = GameControl.getRandomNumber(100, 10);
        assertEquals(-2, random);

        random = GameControl.getRandomNumber(5, 5);
        assertEquals(-2, random);
    }
    
    @Test 
    public void maxIntegerTest(){
        int random = GameControl.getRandomNumber(0, Integer.MAX_VALUE);
        assertEquals(-3, random);
    }


    @Test
    public void validRangeTest(){

        // Make sure GameControl has a normal Random in it.
        GameControl.setRandomGenerator(new java.util.Random());

        int[][] testRanges = new int[][]{
            {1, 10},
            {15, 100},
            {5, 6},
            {0, Integer.MAX_VALUE-1}
        };

        for (int i=0; i < testRanges.length; i++){
            int low = testRanges[i][0];
            int high = testRanges[i][1];

            int random = GameControl.getRandomNumber(low, high);
            System.out.printf("%d <= %d <= %d\n", low, random, high);
            
            assertTrue(
                String.format("%d should be between %d and %d", random, low, high),
                random >= low && random <= high);
        }
    }

}