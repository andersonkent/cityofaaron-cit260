package view;

import java.util.function.BooleanSupplier;

import app.CityOfAaron;
import model.Location;
import model.Map;
import model.Point;

public class MapView extends ReadOnlyView {

    @Override
    public BooleanSupplier getPostMessageAction() {
        return () -> { return false; };
    }

    @Override
    public String getMessage() {
        return getMapPrintout();
    }
    


    private String getMapPrintout() {

        Map map = CityOfAaron.getCurrentGame().getTheMap();
        if (map == null || map.getLocations() == null){
            return "Uh oh. The Map does not yet exist.";
        }

        StringBuilder printout = new StringBuilder();

        printout.append("CITY OF AARON and the Land Roundabout\n\n");

        for (Location[] row : map.getLocations()) {
            for (Location location : row) {
                if (location == null){
                    printout.append("- ");
                } else {
                    printout.append(location.getMapSymbol()).append(" ");
                }
            }
            printout.append("\n");
        }

        printout.append("\n");
        
        Point currentPoint = map.getCurrentLocation();
        Location currentLocation = map.getLocations()[currentPoint.getRow()][currentPoint.getColumn()];
        
        printout.append("You are currently in the following location:\n");
        printout.append(String.format("%s (%s) [%d, %d]", 
            currentLocation.getName(), currentLocation.getMapSymbol(),
            currentPoint.getRow(), currentPoint.getColumn()));

        return printout.toString();
    }

}