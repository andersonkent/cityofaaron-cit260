package control;

import org.junit.Test;
import static org.junit.Assert.*;
import model.Game;

public class GameShouldEndTests {

    @Test
    public void gameDoesNotEnd(){
        Game game = Game.builder().currentPopulation(75).build();
        boolean endGame = GameControl.gameShouldEnd(game, 100);
        assertFalse(endGame);
    }
    
    @Test
    public void gameEnds(){
        Game game = Game.builder().currentPopulation(45).build();
        boolean endGame = GameControl.gameShouldEnd(game, 100);
        assertTrue(endGame);
    }
    
}