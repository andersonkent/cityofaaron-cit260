package control;


public class WheatControl {

    /**
     * Calculate the amount of wheat harvested based on acresPlanted and tithing level.
     * <ul>Requirements:
     * <li>acresPlanted must be >= 0</li>
     * <li>tithingLevel must be between 0 and 100</li>
     * <li><ul>Outputs:
     *      <li>Tithing &lt; 8%, acres * random(1,3)</li>
     *      <li>Tithing 8% - 12%, acres * random(2,4)</li>
     *      <li>tithing &gt; 12%, acres * random(2,5)</li>
     *      </ul></li>
     * </ul>
     * @param tithesPercent
     * @param acresPlanted
     * @return The number of bushels harvested
     */
    public static int calculateHarvest(int tithesPercent, int acresPlanted){
        
        if (acresPlanted < 0){
            return -1;
        }

        if (tithesPercent < 0 || tithesPercent > 100){
            return -2;
        }

        int low = 0;
        int high = 0;

        if (tithesPercent < 8){
            low = 1;
            high = 3;
        } else if (tithesPercent >= 8 && tithesPercent <= 12){
            low = 2;
            high = 4;
        } else {
            low = 2;
            high = 5;
        }
 
        int yieldPerAcre = GameControl.getRandomNumber(low, high);
        return yieldPerAcre * acresPlanted;
    }


    /**
     * Calculate the amount of wheat lost to rats based on wheatInStorage and tithing level.
     * <ul>Requirements:
     * <li>wheatInStorage must be >= 0</li>
     * <li>tithingLevel must be between 0 and 100</li>
     * <li><ul>Outputs:
     *      <li>Tithing &lt; 8%, wheat * random(6,10)%</li>
     *      <li>Tithing 8% - 12%, wheat * random(3,7)%</li>
     *      <li>tithing &gt; 12%, wheat * random(3,5)%</li>
     *      </ul></li>
     * </ul>
     * @param tithesPercent
     * @param acresPlanted
     * @return The number of bushels lost
     */
    public static int calculateLossToRats(int tithesPercent, int wheatInStorage){

        if (wheatInStorage < 0){
            return -1;
        }

        if (tithesPercent < 0 || tithesPercent > 100){
            return -2;
        }

        int chanceOfRats = GameControl.getRandomNumber(1, 100);
        if (chanceOfRats >= 30){
            // no rats this time
            return 0; 
        }

        int low;
        int high;

        if (tithesPercent < 8){
            low = 6;
            high = 10;
        } else if (tithesPercent >= 8 && tithesPercent <= 12){
            low = 3;
            high = 7;
        } else {
            low = 3;
            high = 5;
        }

        double percentLost = GameControl.getRandomNumber(low, high) * 0.01;

        return (int)Math.round(wheatInStorage * percentLost);
    }



}