package org.statedesignpattern.models;

import java.util.Map;

public class Inventory {
    private Map<Integer, ItemShelf> itemShelves;

    public Inventory(Map<Integer, ItemShelf> itemShelves) {
        this.itemShelves = itemShelves;
    }

    public ItemShelf getItemShelf(int productCode) {
        return itemShelves.get(productCode);
    }

    public void displayInventory() {
        System.out.println("######################################################");
        for (ItemShelf itemShelf : itemShelves.values()) {
            System.out.println("productCode: " + itemShelf.getCode() + ", productType: " +
                    itemShelf.getItem().getItemType() + ", productPrice: " + itemShelf.getPrice() +
                    ", productCount: " + itemShelf.getItemCount());
        }
        System.out.println("######################################################");
    }
}
