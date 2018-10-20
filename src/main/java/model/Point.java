package model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Point {
    int row;
    int column;
}