package control;


public class PeopleControl {

    /**
     * Calcualte the number of people who moved into the city during the 
     * year. The number will be between 1% and 5% of the current year's 
     * population.
     * 
     * @param currentPopulation The current year's population
     */
    public static int calculateNewMoveIns(int currentPopulation){
        
        if (currentPopulation < 0){
            return -1;
        }

        double growthRate = (double)GameControl.getRandomNumber(1, 5) / 100.0;
        return (int)(currentPopulation * growthRate);
    }


    /**
     * Calculate the number of people who died as a result of not being fed
     * enough food to survive during the year.
     * 
     * @param bushelsForFood The number of bushels of wheat allocated as food
     * @param currentPopulation The current number of people to be fed.
     */
    public static int calculateMortality(int bushelsForFood, int currentPopulation){
        
        if (bushelsForFood < 0){
            return -1;
        }

        if (currentPopulation < 0){
            return -2;
        }

        int numberPeopleFed = (int)Math.round((double)bushelsForFood / 20);

        if (numberPeopleFed > currentPopulation){
            // everyone ate this year
            return 0; 
        }

        return currentPopulation - numberPeopleFed;
    }



}