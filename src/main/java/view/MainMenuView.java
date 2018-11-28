
package view;

import app.CityOfAaron;
import control.GameControl;
import model.Game;

/**
 *
 * @author kanderson
 */
public class MainMenuView extends MenuView {

    /**
     * Constructor
     */
    public MainMenuView() {
        super();
    }

    @Override
    public String getMenuIntroduction() {
        return "MAIN MENU";
    }

    @Override
    public MenuItem[] getMenuItems() {
        return new MenuItem[] {
            new MenuItem("N", "Start a new game", () -> {
                new NewGameView().displayView();
                return true;
            }),

            new MenuItem("L", "Load a saved game", () -> {
                loadGame();
                return true;
            }),

            HELP_MENU,

            new MenuItem("Q", "Quit the program", () -> {
                // keep going = false
                return false;
            }) };
    }



    private void loadGame(){
        GetFilenameView filenameView = new GetFilenameView(GetFilenameView.FileMode.Load);
        filenameView.displayView();
        if (filenameView.hasFilename() == false){
            System.out.println("No file entered. No game was loaded.");
            return;
        }

        Game game = GameControl.loadGameFromFile(filenameView.getFilename());
        CityOfAaron.setCurrentGame(game);
        new GameMenuView().displayView();
    }

}
