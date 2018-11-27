package view;

import java.util.function.BooleanSupplier;

/**
 *
 * @author kanderson
 */
public class StartProgramView extends ReadOnlyView {
    
    
    
    /**
     * Constructor
     */
    public StartProgramView(){
        super();
    }

    public String getMessage(){
    
        return
          "/---------------------------------------------------\\\n"
        + "|  WELCOME TO THE CITY OF AARON!                    |\\\n"
        + "|                                                   |\\\n"
        + "|  You have just been elected chief magistrate for  |\\\n"
        + "|  a period of  10 years.  In this time, you alone  |\\\n"
        + "|  are responsible for the growth of  the city and  |\\\n"
        + "|  for the  care of those who  come to live within  |\\\n"
        + "|  its borders.                                     |\\\n"
        + "|                                                   |\\\n"
        + "|  You must buy and sell land at profitable prices  |\\\n"
        + "|  in order to maintain wheat stores sufficient to  |\\\n"
        + "|  feed  your people,  and to plant  for a harvest  |\\\n"
        + "|  that will allow further growth of the city.      |\\\n"
        + "|                                                   |\\\n"
        + "|  After 10 years,  your time as  chief magistrate  |\\\n"
        + "|  will  come to  an end  and you  will be  judged  |\\\n"
        + "|  according  to  the  success  you  have  brought  |\\\n"
        + "|  about. If at any time before your term ends the  |\\\n"
        + "|  people become  weary of your  leadership,  they  |\\\n"
        + "|  can chose to overthrow you,  and your time will  |\\\n"
        + "|  end prematurely.                                 |\\\n"
        + "|                                                   |\\\n"
        + "|  GOOD LUCK!                                       |\\\n"
        + "\\---------------------------------------------------/\\\n";
                
    }
    
    
    
    @Override
    public BooleanSupplier getPostMessageAction() {
        return () -> {
            pause(1500);
            loadMainMenu();
            return false;
        };
	}
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void loadMainMenu(){
        
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayView();
        
        System.out.println(
              "/---------------------------------------------------\\\n"
            + "|  GOOD-BYE!                                        |\\\n"
            + "|                                                   |\\\n"
            + "|  Thank you for playing.                           |\\\n"
            + "\\---------------------------------------------------/\\\n");

    }

    
}
