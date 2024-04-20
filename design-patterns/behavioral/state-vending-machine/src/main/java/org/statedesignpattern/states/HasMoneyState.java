package org.statedesignpattern.states;

import org.statedesignpattern.enums.Coin;
import org.statedesignpattern.interfaces.IState;
import org.statedesignpattern.models.VendingMachine;

public class HasMoneyState implements IState {
    public HasMoneyState() {
        System.out.println("Entered Has Money state");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vm) {
        throw new RuntimeException("invalid operation");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vm) {
        vm.setState(new ProductSelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        vm.addCoin(coin);
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
        System.out.println("refund initiated, please check the coin tray");
        vm.refundCoins();
        vm.setState(new IdleState());
    }
}
