package view;

import java.util.function.BooleanSupplier;



public abstract class ReadOnlyView extends ViewBase {

    public abstract BooleanSupplier getPostMessageAction();

    @Override
    public String[] getInputs() {
        return null;
    }

    @Override
    public boolean doAction(String[] inputs) {
        BooleanSupplier action = getPostMessageAction();
        if (action == null) {
            return false;
        }

        return action.getAsBoolean();
    }

}