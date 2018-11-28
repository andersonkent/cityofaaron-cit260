
package view;

import app.CityOfAaron;
import control.GameControl;
import model.Game;

/**
 *
 * @author kanderson
 */
public class NewGameView extends UserInputView {
    
    
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
    
    @Override
    public UserInputItem[] getUserInputItems() {
        return new UserInputItem[] {
            new UserInputItem("Please enter your name, or simply press Enter to return to the previous menu:")
        };
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
        Game game = GameControl.createNewGame(playerName);
        CityOfAaron.setCurrentGame(game);

        // todo: lots more initialization to do here...

        new GameMenuView().displayView();
    }
}
