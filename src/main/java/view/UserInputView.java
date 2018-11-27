package view;

import java.util.ArrayList;
import java.util.function.Function;

public abstract class UserInputView extends ViewBase {

    protected class UserInputItem {
        public String prompt;
        public Function<String,Boolean>[] validators;

        public UserInputItem(String prompt, Function<String,Boolean>... validators) {
            this.prompt = prompt;
            this.validators = validators;
        }
    }


    public abstract UserInputItem[] getUserInputItems();

    @Override
    public String[] getInputs() {

        UserInputItem[] inputItems = getUserInputItems();
        if (inputItems == null || inputItems.length == 0){
            return null;
        }

        ArrayList<String> inputs = new ArrayList<>();

        for (UserInputItem input : inputItems){
            inputs.add(getUserInput(input.prompt, input.validators));
        }        

        final String[] template = new String[]{};
        return inputs.toArray(template);
    }

    



}