package org.statedesignpattern.states;

import org.statedesignpattern.enums.Coin;
import org.statedesignpattern.interfaces.IState;
import org.statedesignpattern.models.VendingMachine;

public class DispenseProductState implements IState {
    public DispenseProductState() {
        System.out.println("Entered Product Dispense State");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vm) {
        throw new RuntimeException("invalid operation");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vm) {
        throw new RuntimeException("invalid operation");
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        throw new RuntimeException("invalid operation");
    }

    @Override
    public void selectProduct(VendingMachine vm, int productId) {
        throw new RuntimeException("invalid operation");
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
        System.out.println("dispensed the product, please check the product tray");
        vm.setState(new IdleState());
    }

    @Override
    public void refund(VendingMachine vm) {
        throw new RuntimeException("invalid operation");
    }
}
