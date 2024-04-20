package org.statedesignpattern.models;

public class ItemShelf {
    private int code;
    private final Item item;
    private int itemCount;

    public ItemShelf(int code, Item item, int itemCount) {
        this.code = code;
        this.item = item;
        this.itemCount = itemCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPrice() {
        return item.getAmount();
    }

    public int getCode() {
        return code;
    }

    public Item getItem() {
        return item;
    }
}
