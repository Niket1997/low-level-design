package org.statedesignpattern.states;

import org.statedesignpattern.enums.Coin;
import org.statedesignpattern.interfaces.IState;
import org.statedesignpattern.models.VendingMachine;

public class IdleState implements IState {
    public IdleState() {
        System.out.println("Entered Idle State");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vm) {
        vm.setState(new HasMoneyState());
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
        throw new RuntimeException("invalid operation");
    }

    @Override
    public void refund(VendingMachine vm) {
        throw new RuntimeException("invalid operation");
    }
}
