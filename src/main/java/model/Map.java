package model;

import lombok.*;

@Data
@Builder
public class Map {
    private Location[][] locations;
    private Point currentLocation;
}