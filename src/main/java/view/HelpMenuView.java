package view;


public class HelpMenuView extends MenuView {

    @Override
    public String getMenuIntroduction() {
        return "HELP MENU";
    }

    @Override
    public MenuItem[] getMenuItems() {
        
        return new MenuItem[] {

            new MenuItem("G", "What are the goals of the game?", () -> {
                System.out.println("Coming soon");
                return true;
            }),

            new MenuItem("W", "Where is the City of Aaron?", () -> {
                System.out.println("Coming soon");
                return true;
            }),

            new MenuItem("M", "How do I view the map?", () -> {
                System.out.println("Coming soon");
                return true;
            }),

            new MenuItem("L", "How do I move to a new location?", () -> {
                System.out.println("Coming soon");
                return true;
            }),

            new MenuItem("S", "How do I view what's in my storehouse?", () -> {
                System.out.println("Coming soon");
                return true;
            }),

            new MenuItem("Q", "Return to the previous menu", () -> {
                return false;
            }),
        };
    }


}