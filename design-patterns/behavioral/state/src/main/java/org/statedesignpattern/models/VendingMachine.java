package org.statedesignpattern.models;

import org.statedesignpattern.enums.Coin;
import org.statedesignpattern.interfaces.IState;
import org.statedesignpattern.states.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private IState state;
    private List<Coin> coins;
    private Inventory inventory;

    public VendingMachine(Inventory inventory) {
        this.state = new IdleState();
        this.coins = new ArrayList<>();
        this.inventory = inventory;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public IState getState() {
        return state;
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public void refundCoins() {
        this.coins.clear();
    }

    public List<Coin> getCoins() {
        return this.coins;
    }

    public ItemShelf getItemShelf(int productCode) {
        return inventory.getItemShelf(productCode);
    }
}
