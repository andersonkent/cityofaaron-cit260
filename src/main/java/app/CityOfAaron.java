/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */
package app;

import java.util.ArrayList;
import java.util.Arrays;

import model.Animal;
import model.Author;
import model.Condition;
import model.Game;
import model.InventoryItem;
import model.ItemType;
import model.Location;
import model.Map;
import model.Player;
import model.Point;
import model.Provision;
import model.Storehouse;

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {

        Player player = new Player("Kent");
        System.out.println(player);

        Point point = new Point(3, 3);
        System.out.println(point);

        Location location = Location.builder()
            .name("Temple")
            .mapSymbol("T")
            .gameTips(new String[]{"Tip1", "Tip2", "Tip3"})
            .build();
        System.out.println(location);

        Map map = Map.builder()
            .locations(new Location[][]{ { location }} )
            .currentLocation(point)
            .build();
        System.out.println(map);

        Author author = new Author("Kent Anderson", "Happy Programmer");
        System.out.println(author);

        Animal animal = new Animal("Lion", 10, 1, Condition.Good);
        System.out.println(animal);

        Provision provision = new Provision("Lumber", false, 10, Condition.Fair);
        System.out.println(provision);

        InventoryItem tool = new InventoryItem("Hammer", ItemType.Tool, 100, Condition.Good);
        System.out.println(tool);

        Storehouse storehouse = Storehouse.builder()
            .authors(new Author[] { author })
            .animals(new ArrayList<>(Arrays.asList(animal)))
            .tools(new ArrayList<>(Arrays.asList(tool)))
            .provisions(new ArrayList<>(Arrays.asList(provision)))
            .build();
        System.out.println(storehouse);

        Game game = Game.builder()
            .acresOwned(1000)
            .currentPopulation(1000)
            .wheatInStorage(15000)
            .theMap(map)
            .theStorehouse(storehouse)
            .thePlayer(player)
            .build();
        System.out.println(game);
    }

}