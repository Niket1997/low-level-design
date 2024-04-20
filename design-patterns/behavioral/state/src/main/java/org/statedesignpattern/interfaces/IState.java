package org.statedesignpattern.interfaces;

import org.statedesignpattern.enums.Coin;
import org.statedesignpattern.models.VendingMachine;

public interface IState {
    void pressInsertCoinButton(VendingMachine vm);

    void pressSelectProductButton(VendingMachine vm);

    void insertCoin(VendingMachine vm, Coin coin);

    void selectProduct(VendingMachine vm, int productId);

    void dispenseProduct(VendingMachine vm);

    void refund(VendingMachine vm);
}
