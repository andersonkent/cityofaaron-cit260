package control;

import java.util.Random;

import model.Game;
import model.Player;
import model.AnnualReport;


public class GameControl {

    private static Random randomGenerator = new Random();

    /**
     * Protected setter for tests to inject a mock random object.
     * @param random
     */
    protected static void setRandomGenerator(Random random){
        randomGenerator = random;
    }
    
    /**
     * Returns a fully initialized Game object
     * @param playerName
     * @return
     */
    public static Game createNewGame(String playerName){
        Player player = new Player(playerName);
        Game game = Game.builder().thePlayer(player).build();
        return game;
    }


    public static Game loadGameFromFile(String filename){
        return null;
    }


    public static void saveGameToFile(Game game, String filename)
    {
        return;
    }


    public static boolean gameShouldEnd(Game game, int previousPopulation){
        if (game.getCurrentPopulation() < (previousPopulation / 2)){
            return true;
        }

        return false;
    }


    public static double calculateFinalUserRating(Game game){
        return 0.0;
    }


    /**
     * Process the current year's results and update the Game 
     * object.
     * 
     * @param game The current Game object (pass by reference)
     * @param tithesPercent The percentage of tithing selected for the year
     * @param bushelsForFood The number of bushels of wheat allocated as food for the year
     * @param acresToPlant The number of acres to be used for planting
     * 
     * @return The year's Annual Report data
     */
    public static AnnualReport liveTheYear(
            Game game, int tithesPercent, 
            int bushelsForFood, int acresToPlant){

        if (game == null || tithesPercent < 0 || tithesPercent > 100
                || bushelsForFood < 0 || acresToPlant < 0) {
            return null;
        }

        AnnualReport report = new AnnualReport();
        report.setLandPrice(LandControl.getCurrentLandPrice());

        int totalWheat = game.getWheatInStorage();

        int harvested = WheatControl.calculateHarvest(tithesPercent, acresToPlant);
        int tithingAmount = (int)(double)((tithesPercent/100.0) * harvested);
        int lostToRats = WheatControl.calculateLossToRats(tithesPercent, totalWheat);

        int peopleStarved = PeopleControl.calculateMortality(bushelsForFood, game.getCurrentPopulation());
        int peopleMovedIn = PeopleControl.calculateNewMoveIns(game.getCurrentPopulation());

        totalWheat = totalWheat + harvested - tithingAmount - lostToRats;
        game.setWheatInStorage(totalWheat);
        game.setCurrentPopulation(game.getCurrentPopulation() - peopleStarved + peopleMovedIn);

        report.setBushelsHarvested(harvested);
        report.setTithingAmount(tithingAmount);
        report.setLostToRats(lostToRats);
        report.setPeopleStarved(peopleStarved);
        report.setPeopleMovedIn(peopleMovedIn);

        report.setEndingWheatInStorage(game.getWheatInStorage());
        report.setEndingPopulation(game.getCurrentPopulation());
        report.setEndingAcresOwned(game.getAcresOwned());
        
        return report;
    }


    /**
     * Generates a random integer between lowValue and highValue, inclusive.
     * <ul>Requirements:
     * <li>lowValue and highValue must be positive integers (&gt;= 0) (return -1)</li>
     * <li>highValue must be greater than lowValue (return -2)</li>
     * <li>highValue cannot be equal to the maximum value for integers (return -3)</li>
     * </ul>
     * @param lowValue
     * @param highValue
     * @return The random number
     */
    public static int getRandomNumber(int lowValue, int highValue){
        
        // if low < 0 or high < 0 then return -1
        if (lowValue < 0 || highValue < 0){
            return -1;
        }
        
        // if high <= low then return -2
        if (highValue <= lowValue){
            return -2;
        }
        
        // if high is the maximum value for integers, then return -3
        if (highValue == Integer.MAX_VALUE){
            return -3;
        }
        
        // calculate the size of the range; add one so Random() includes high value
        int range = (highValue - lowValue) + 1;
        
        // return low + random(range size)
        return lowValue + randomGenerator.nextInt(range);
    }

}