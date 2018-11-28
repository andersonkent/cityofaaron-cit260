package view;

public class ReportsMenuView extends MenuView {

    @Override
    public String getMenuIntroduction() {
        return "REPORTS MENU";
    }

    @Override
    public MenuItem[] getMenuItems() {
        return new MenuItem[] {
            new MenuItem("A", "View the animals report", () -> {
                System.out.println("Animals coming soon");
                return true;
            }),

            new MenuItem("T", "View the tools report", () -> {
                System.out.println("Tools coming soon");
                return true;
            }),

            new MenuItem("P", "View the provisions report", () -> {
                System.out.println("Provisions coming soon");
                return true;
            }),

            new MenuItem("AU", "View the authors", () -> {
                System.out.println("Authors coming soon");
                return true;
            }),

            HELP_MENU,

            new MenuItem("Q", "Return to the previous menu", () -> {
                return false;
            }),
        };
    }

}