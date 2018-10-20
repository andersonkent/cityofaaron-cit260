package model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Author {
    private String name;
    private String title;
}