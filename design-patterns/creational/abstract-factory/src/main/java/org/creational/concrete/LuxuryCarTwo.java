package org.creational.concrete;

import org.creational.interfaces.ICar;

public class LuxuryCarTwo implements ICar {
    @Override
    public void drive() {
        System.out.println("driving luxury car two");
    }
}
