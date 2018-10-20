package model;

import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Provision extends InventoryItem {
    private boolean perishable;

    public Provision(String name, boolean perishable, int quantity, Condition condition) {
        super(name, ItemType.Provisions, quantity, condition);
        setPerishable(perishable);
    }
}