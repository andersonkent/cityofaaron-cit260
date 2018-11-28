package control;

import java.util.ArrayList;

import model.Animal;
import model.Author;
import model.InventoryItem;
import model.Provision;
import model.Storehouse;

public class StorehouseControl {


    public static Storehouse createStorehouse(){

        return Storehouse.builder()
        .animals(createAnimals())
        .tools(createTools())
        .provisions(createProvisions())
        .authors(createAuthors()).build();
    }


    private static ArrayList<Animal> createAnimals(){
        return null;
    }


    private static ArrayList<InventoryItem> createTools(){
        return null;
    }


    private static ArrayList<Provision> createProvisions(){
        return null;
    }


    private static Author[] createAuthors() {
        return new Author[] { new Author("Kent Anderson", "Senior Software Developer") };
    }
}