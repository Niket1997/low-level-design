package org.creational.concrete;

import org.creational.interfaces.ICar;

public class EconomicCarOne implements ICar {
    @Override
    public void drive() {
        System.out.println("driving economy car one");
    }
}
