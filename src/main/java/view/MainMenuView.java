
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
                System.out.println("Load game called.");
                return true;
            }),

            new MenuItem("H", "Help menu", () -> {
                System.out.println("Help menu called.");
                return true;
            }),

            new MenuItem("Q", "Quit the program", () -> {
                // keep going = false
                return false;
            }) };
    }

}
