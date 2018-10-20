package model;

import java.util.ArrayList;

import lombok.*;

@Data
@Builder
public class Storehouse {
    private Author[] authors;
    private ArrayList<Animal> animals;
    private ArrayList<InventoryItem> tools;
    private ArrayList<Provision> provisions;
}