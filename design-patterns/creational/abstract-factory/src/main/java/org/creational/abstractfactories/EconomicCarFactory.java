package org.creational.abstractfactories;

import org.creational.concrete.EconomicCarOne;
import org.creational.concrete.EconomicCarTwo;
import org.creational.interfaces.IAbstractFactory;
import org.creational.interfaces.ICar;

public class EconomicCarFactory implements IAbstractFactory {
    @Override
    public ICar getInstance(int price) {
        if (price <= 300000) {
            return new EconomicCarOne();
        }

        return new EconomicCarTwo();
    }
}
