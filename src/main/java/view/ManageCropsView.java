package view;


public class ManageCropsView extends MenuView {

    @Override
    public String getMenuIntroduction() {
        return "MANAGE CROPS";
    }

    @Override
    public MenuItem[] getMenuItems() {
        return new MenuItem[] {
            new MenuItem("B", "Buy land", () -> {
                System.out.println("Buy land coming soon");
                return true;
            }),

            new MenuItem("S", "Sell land", () -> {
                System.out.println("Sell land coming soon");
                return true;
            }),

            new MenuItem("F", "Feed the people", () -> {
                System.out.println("Feed people coming soon");
                return true;
            }),

            new MenuItem("C", "Plant crops", () -> {
                System.out.println("Plant crops coming soon");
                return true;
            }),

            new MenuItem("T", "Tithes and offerings", () -> {
                System.out.println("Tithes and offerings coming soon");
                return true;
            }),

            new MenuItem("Q", "Return to the previous menu", () -> {
                return false;
            }),
        };
    }

}