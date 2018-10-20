package model;

import lombok.*;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Animal extends InventoryItem {
    private int age;

    public Animal(String name, int age, int quantity, Condition condition) {
        super(name, ItemType.Animal, quantity, condition);
        setAge(age);
    }
}