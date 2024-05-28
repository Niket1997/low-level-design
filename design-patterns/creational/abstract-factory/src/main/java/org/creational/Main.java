package org.creational;

import org.creational.interfaces.IAbstractFactory;
import org.creational.interfaces.ICar;

public class Main {
    public static void main(String[] args) {
        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
        IAbstractFactory economicCarFactory = abstractFactoryProducer.getFactory("EconomicCar");
        ICar economicCarOne = economicCarFactory.getInstance(20000);
        economicCarOne.drive();
    }
}