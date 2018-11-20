
package view;

/**
 *
 * @author kanderson
 */
public class MainMenuView extends ViewBase {
    
    
    /**
     * Constructor
     */
    public MainMenuView(){
        super();
    }

    public String getMessage(){
        
        return
            "MAIN MENU\n"
            + "N - Start a New Game\n"
            + "L - Load a Saved Game\n"
            + "H - Help Menu\n"
            + "Q - Quit the Program\n";
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
            "Please make your selection:", 
            "Please select a valid menu option\n",
            ViewBase::notNullOrWhitespace,
            s -> ViewBase.in(s.toUpperCase(), "N", "L", "H", "Q"));
        
        return inputs;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){

        // keep going unless some menu option below changes it.
        boolean keepGoing = true;

        if (inputs == null || inputs[0] == null){
            // no input = keep going until they provide input
            return keepGoing;
        }

        switch(inputs[0].toUpperCase()) {
            case "N":
                newGame();
                break;
            case "L":
                loadGame();
                break;
            case "H":
                helpMenu();
                break;
            case "Q":
                keepGoing = false;
                break;
        }
        
        return keepGoing;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void newGame(){
        new NewGameView().displayView();
    }

    private void loadGame(){
        System.out.println("loadGame called.");
    }

    private void helpMenu(){
        System.out.println("helpMenu called.");
    }
}
