package model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Location {
    public String name;
    public String mapSymbol;
    public String[] gameTips;
}