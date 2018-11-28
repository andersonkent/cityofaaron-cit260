package control;

import model.Location;
import model.Map;
import model.Point;


public class MapControl {

    public static Map createMap() {

        Location[][] locations = new Location[][] {
            {
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
            },
            {
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
            },
            {
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
            },
            {
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
            },
            {
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
                Location.builder().mapSymbol("U").name("Undeveloped Land").gameTips(new String[]{}).build(),
            },
        };

        return Map.builder()
        .locations(locations)
        .currentLocation(new Point(0,0))
        .build();
    }

}