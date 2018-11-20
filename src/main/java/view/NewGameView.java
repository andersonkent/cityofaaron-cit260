
package view;

import app.CityOfAaron;
import model.Game;
import model.Player;

/**
 *
 * @author kanderson
 */
public class NewGameView extends ViewBase {
    
    
    /**
     * Constructor
     */
    public NewGameView(){
        super();
    }

    public String getMessage(){
        return "We are beginning a new game. You'll have 10 years to\n"
            + "make your mark on the city. Good luck!\n\n";
    }
    
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput(
            "Please enter your name, or simply press Enter to return to the previous menu:");
        
        return inputs;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){

        if (inputs != null 
            && inputs[0] != null
            && inputs[0].trim().length() > 0) {
            
            // start the game
            newGame(inputs[0]); 
        }

        // Always return to the main menu from here. This view
        // doesn't do anything except start the new game.
        return false;
    }
    
    
    private void newGame(String playerName){
        Player player = new Player(playerName);
        Game game = Game.builder().thePlayer(player).build();
        CityOfAaron.setCurrentGame(game);

        // todo: lots more initialization to do here...
    }
}