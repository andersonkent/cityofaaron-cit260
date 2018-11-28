package view;

public class GameMenuView extends MenuView {

    @Override
    public String getMenuIntroduction() {
        return "GAME MENU";
    }

    @Override
    public MenuItem[] getMenuItems() {
        return new MenuItem[] {
            
            new MenuItem("M", "View the map", () -> {
                System.out.println("Map coming soon");
                return true;
            }),

            new MenuItem("L", "Move to a new location", () -> {
                System.out.println("Move function coming soon");
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
                System.out.println("Save game coming soon");
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

}