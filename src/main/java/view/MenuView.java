package view;

import java.util.function.BooleanSupplier;

public abstract class MenuView extends ViewBase {

    protected class MenuItem {
        public String menuId;
        public String description;
        public BooleanSupplier menuHandler;

        public MenuItem(String menuId, String description, BooleanSupplier handler){
            this.menuId = menuId;
            this.description = description;
            this.menuHandler = handler;
        }
    }

    private MenuItem[] menuItems = null;


    protected final MenuItem HELP_MENU = new MenuItem("H", "Help menu", () -> {
        new HelpMenuView().displayView();
        return true;
    });


    public abstract String getMenuIntroduction();
    public abstract MenuItem[] getMenuItems();

    public MenuView() {
        super();
        menuItems = getMenuItems();
    }

    @Override
    public String getMessage() {
        StringBuilder menu = new StringBuilder();
        
        String intro = getMenuIntroduction();
        if (intro != null){
            menu.append(intro);
            menu.append("\n\n");
        }

        for (MenuItem menuItem : menuItems) {
            menu.append(menuItem.menuId).append(" - ").append(menuItem.description).append("\n");
        }

        menu.append("\n");
        return menu.toString();
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = getUserInput("Please enter your selection:",
            input -> {
                String inputTrimmed = input.trim().toUpperCase();
                boolean found = false;
                for (MenuItem item : menuItems){
                    if (item.menuId.toUpperCase().equals(inputTrimmed)){
                        found = true;
                        break;
                    }
                }
                if (found == false){
                    return false;
                }
                return true;
            });
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        String inputTrimmed = inputs[0].trim().toUpperCase();

        // Find the menu item and call its handler.
        for(MenuItem menuItem : menuItems){
            if (menuItem.menuId.toUpperCase().equals(inputTrimmed)){
                return menuItem.menuHandler.getAsBoolean();
            }
        }

        // Nothing handled it, so return "keep going"
        return true;
    }

}