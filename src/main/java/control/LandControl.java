package control;

public class LandControl {

    // The price per acre of land, in bushels of wheat
    private static int currentPrice;

    /**
     * Updates the current land price for the year.
     */
    public static void updateCurrentLandPrice(){
        currentPrice = GameControl.getRandomNumber(17, 27);
    }


    /**
     * Returns the current land price
     */
    public static int getCurrentLandPrice(){
        return currentPrice;
    }


    /**
     * Returns the total cost in wheat for the given number
     * of acres at the current land price.
     * 
     * @param acres The number of acres to be valued
     */
    public static int getBushelsForLand(int acres) {
        if (acres < 0){
            return -1;
        }

        return acres * currentPrice;
    }

}