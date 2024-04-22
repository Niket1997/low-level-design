package org.statedesignpattern;

import org.statedesignpattern.enums.Coin;
import org.statedesignpattern.enums.ItemType;
import org.statedesignpattern.models.Inventory;
import org.statedesignpattern.models.Item;
import org.statedesignpattern.models.ItemShelf;
import org.statedesignpattern.models.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // create & display inventory
        Inventory inventory = createInventory();
        inventory.displayInventory();

        // create vending machine in idle state
        VendingMachine vm = new VendingMachine(inventory);

        // press insert coin button
        vm.getState().pressInsertCoinButton(vm);

        // insert coin
        vm.getState().insertCoin(vm, Coin.DIME);
        vm.getState().insertCoin(vm, Coin.NICKEL);
        vm.getState().insertCoin(vm, Coin.NICKEL);

        // enter product selection state
        vm.getState().pressSelectProductButton(vm);

        // choose product
        vm.getState().selectProduct(vm, 107);

        // dispense product
        vm.getState().dispenseProduct(vm);

        // display inventory
        inventory.displayInventory();
    }

    private static Inventory createInventory() {
        System.out.println("creating inventory");
        Map<Integer, ItemShelf> itemShelves = new HashMap<>();
        for (int i = 101; i <= 110; i++) {
            Item item;
            if (i <= 103) {
                item = new Item(ItemType.COKE, 10);
            } else if (i <= 106) {
                item = new Item(ItemType.PEPSI, 12);
            } else if (i <= 109) {
                item = new Item(ItemType.JUICE, 15);
            } else {
                item = new Item(ItemType.SODA, 8);
            }
            itemShelves.put(i, new ItemShelf(i, item, 5));
        }
        return new Inventory(itemShelves);
    }
}