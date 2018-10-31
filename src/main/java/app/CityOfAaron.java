/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */
package app;

import view.StartProgramView;

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {

        StartProgramView view = new StartProgramView();
        view.displayView();
    }

}