/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */
package app;

import model.Game;
import view.StartProgramView;

public class CityOfAaron {

    private static Game currentGame;


    public static Game getCurrentGame(){
        return currentGame;
    }

    public static void setCurrentGame(Game game) {
        currentGame = game;
    }

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {

        StartProgramView view = new StartProgramView();
        view.displayView();
    }

}