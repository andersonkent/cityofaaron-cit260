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
        return -1;
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
        return -1;
    }



}