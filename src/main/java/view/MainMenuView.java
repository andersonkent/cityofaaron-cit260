
package view;

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
        GetFilenameView filenameView = new GetFilenameView(GetFilenameView.FileMode.Open);
        filenameView.displayView();
        if (filenameView.hasFilename() == false){
            System.out.println("No file entered");
            return;
        }

        System.out.println("Will load game from " + filenameView.getFilename());
    }

}
