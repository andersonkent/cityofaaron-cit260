
package view;

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author kanderson
 */
public abstract class ViewBase implements View {
    
    
    public abstract String getMessage();

    public abstract String[] getInputs();

    public abstract boolean doAction(String[] inputs);



    /**
     * Constructor
     */
    public ViewBase(){
    }
    
    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param invalidMessage - The message to give the user if the input is invalid.
     * @param validators - A list of functions that accept a string and returns a boolean. If all 
     * validators passed in return true, then the input is valid. 
     * @return The user's input
     */
    protected String getUserInput(String prompt, String invalidMessage, Function<String,Boolean>... validators){
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;

        if (invalidMessage == null){
            invalidMessage = "Invalid input.";
        }
        
        while(inputReceived == false){
            
            System.out.println(prompt);
            input = keyboard.nextLine();
            
            // Make sure we avoid a null-pointer error.
            if (input == null){
                input = "";
            }
            
            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();
            
            if (validators != null){
                for (Function<String,Boolean> validator : validators) {
                    if (validator.apply(input) != Boolean.TRUE){
                        System.out.println(invalidMessage);
                        pause(getInvalidInputPause());
                        continue;
                    }
                }
            }

            // If we get this far, all validators passed.
            inputReceived = true;
        }
        
        return input;
    }
    
    
    /**
     * An overloaded version of getUserInput that prevents null or empty input.
     * @param prompt
     * @return 
     */
    protected String getUserInput(String prompt){
        return getUserInput(prompt, null);
    }

    /**
     * An overloaded version of getUserInput that uses the default invalid input prompt
     * @param prompt The prompt to give to the user
     * @param validators The list of validator functions to apply to the input
     * @return
     */
    protected String getUserInput(String prompt, Function<String,Boolean>... validators){
        return getUserInput(prompt, null, validators);
    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    @Override
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(getMessage());
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    /**
     * Return the number of milliseconds to pause when the user's input
     * is determined to be invalid. Other views can override this if they
     * want.
     * @return
     */
    protected int getInvalidInputPause(){
        return 1500;
    }

    protected static void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exception){
            // do nothing
        }
    }
    

    // Here are our standard validators

    /**
     * Return true if the input string can be converted to an integer.
     * @param input The string input
     * @return
     */
    protected static Boolean integer(String input) {
        try {
            Integer.parseInt(input);
            return Boolean.TRUE;
        } catch (NumberFormatException exception) {
            return Boolean.FALSE;
        }
    }

    /**
     * Returns true if the input string can be converted to a positive integer (>= 0).
     * @param input The string input
     * @return
     */
    protected static Boolean positiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0){
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (NumberFormatException exception){
            return Boolean.FALSE;
        }
    }


    /**
     * Return true if the input string is not not and not empty.
     * @param input The string input
     * @return 
     */
    protected static Boolean notNullOrWhitespace(String input){
        return input != null && input.trim().length() > 0;
    }
    

    /**
     * Determine whether the input is included in a set of values.
     * @param input The string to find in the set.
     * @param values The list of values to search
     * @return
     */
    protected static Boolean in(String input, String... values){

        for (String value : values){
            if (value != null && value.equals(input) == true){
                return Boolean.TRUE;
            }
        }
        // If we get this far, nothing matched.
        return Boolean.FALSE;
    }
}
