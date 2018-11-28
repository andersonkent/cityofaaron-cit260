package view;

import app.CityOfAaron;
import model.Point;

public class NewLocationView extends UserInputView {

    @Override
    public UserInputItem[] getUserInputItems() {
        return new UserInputItem[] {
            new UserInputItem("Enter the row:", ViewBase::positiveInteger),
            new UserInputItem("Enter the column:", ViewBase::positiveInteger),
        };
    }

    @Override
    public String getMessage() {
        return "MOVE TO A NEW LOCATION";
    }

    @Override
    public boolean doAction(String[] inputs) {
        try {
            Point newPoint = new Point(
                Integer.parseInt(inputs[0]),
                Integer.parseInt(inputs[1]));

            CityOfAaron.getCurrentGame().getTheMap().setCurrentLocation(newPoint);
            new MapView().displayView();

        } catch (NumberFormatException exception){
            System.out.println("Error?!!! Our validator should have worked.");
        }

        return false;
    }

}