package org.statedesignpattern.states;

import org.statedesignpattern.enums.Coin;
import org.statedesignpattern.interfaces.IState;
import org.statedesignpattern.models.ItemShelf;
import org.statedesignpattern.models.VendingMachine;

public class ProductSelectionState implements IState {
    public ProductSelectionState() {
        System.out.println("Entered Product Selection State");
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
        ItemShelf itemShelf = vm.getItemShelf(productId);
        if (itemShelf == null) {
            throw new RuntimeException("Invalid product code");
        }

        if (itemShelf.getItemCount() == 0) {
            throw new RuntimeException("no items available for selected product code");
        }

        int totalAmountCollected = 0;
        for (Coin coin : vm.getCoins()) {
            totalAmountCollected += coin.value;
        }

        if (totalAmountCollected < itemShelf.getPrice()) {
            System.out.println("insufficient amount entered");
            this.refund(vm);
            return;
        }

        if (totalAmountCollected > itemShelf.getPrice()) {
            this.returnExtraAmount(totalAmountCollected - itemShelf.getPrice());
        }

        itemShelf.setItemCount(itemShelf.getItemCount() - 1);
        vm.setState(new DispenseProductState());
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
        throw new RuntimeException("invalid operation");
    }

    private void returnExtraAmount(int extraAmount) {
        System.out.println("returned extra amount of " + extraAmount + ", please check the coin tray");
    }

    @Override
    public void refund(VendingMachine vm) {
        System.out.println("refund initiated, please check the coin tray");
        vm.refundCoins();
        vm.setState(new IdleState());
    }
}
