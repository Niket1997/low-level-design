package org.creational;

import org.creational.abstractfactories.EconomicCarFactory;
import org.creational.abstractfactories.LuxuryCarFactory;
import org.creational.interfaces.IAbstractFactory;

public class AbstractFactoryProducer {
    public IAbstractFactory getFactory(String type) {
        if (type.equals("EconomicCar")) {
            return new EconomicCarFactory();
        }

        return new LuxuryCarFactory();
    }
}
