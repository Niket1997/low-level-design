package org.statedesignpattern.enums;

public enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(20);

    public final int value;

    Coin(int value) {
        this.value = value;
    }
}
