package model;

import lombok.*;

@Data
@Builder
public class Game {

    private Player thePlayer;
    private Storehouse theStorehouse;
    private Map theMap;

    private int currentPopulation;
    private int acresOwned;
    private int wheatInStorage;
}