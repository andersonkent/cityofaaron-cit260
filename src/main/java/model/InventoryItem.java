package model;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {
    private String name;
    private ItemType itemType;
    private int quanity;
    private Condition condition;
}