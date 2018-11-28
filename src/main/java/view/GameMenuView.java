package view;

import app.CityOfAaron;
import control.GameControl;

public class GameMenuView extends MenuView {

    @Override
    public String getMenuIntroduction() {
        return "GAME MENU";
    }

    @Override
    public MenuItem[] getMenuItems() {
        return new MenuItem[] {
            
            new MenuItem("M", "View the map", () -> {
                new MapView().displayView();
                return true;
            }),

            new MenuItem("L", "Move to a new location", () -> {
                new NewLocationView().displayView();
                return true;
            }),

            new MenuItem("C", "Manage the crops", () -> {
                new ManageCropsView().displayView();
                return true;
            }),

            new MenuItem("Y", "Live the Year", () -> {
                return liveTheYear();
            }),

            new MenuItem("R", "Reports menu", () -> {
                new ReportsMenuView().displayView();
                return true;
            }),

            new MenuItem("S", "Save the game", () -> {
                saveGame();
                return true;
            }),

            HELP_MENU,
            
            new MenuItem("Q", "End the game and return to the Main Menu", () -> {
                return false;
            })

        };
    }


    private boolean liveTheYear() {
        System.out.println("Live the Year coming soon");
        return true;
    }



    private void saveGame() {

        GetFilenameView filenameView = new GetFilenameView(GetFilenameView.FileMode.Save);
        filenameView.displayView();

        String filename = filenameView.hasFilename() ? filenameView.getFilename() : null;
        if (filename == null){
            System.out.println("No file provided. The game has not been saved.");
            return;
        }

        GameControl.saveGameToFile(CityOfAaron.getCurrentGame(), filename);
        System.out.println("The game has been saved to " + filename);
    }

}