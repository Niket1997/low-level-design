package org.statedesignpattern.models;

import org.statedesignpattern.enums.ItemType;

public class Item {
    private final ItemType itemType;
    private final int amount;

    public Item(ItemType itemType, int amount) {
        this.itemType = itemType;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
