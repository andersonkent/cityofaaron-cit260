package control;

import org.junit.Test;

import model.Game;

import static org.junit.Assert.*;

public class CreateNewGameTests {

    private final String FRED_FLINTSTONE = "Fred Flintstone";

    @Test
    public void testPlayerName(){
        Game game = GameControl.createNewGame(FRED_FLINTSTONE);
        assertEquals(FRED_FLINTSTONE, game.getThePlayer().getName());
    }
}