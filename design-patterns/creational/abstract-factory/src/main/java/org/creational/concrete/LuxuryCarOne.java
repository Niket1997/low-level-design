package org.creational.concrete;

import org.creational.interfaces.ICar;

public class LuxuryCarOne  implements ICar {
    @Override
    public void drive() {
        System.out.println("driving luxury car one");
    }
}
