package org.creational.abstractfactories;

import org.creational.concrete.LuxuryCarOne;
import org.creational.concrete.LuxuryCarTwo;
import org.creational.interfaces.IAbstractFactory;
import org.creational.interfaces.ICar;

public class LuxuryCarFactory implements IAbstractFactory {
    @Override
    public ICar getInstance(int price) {

        if (price < 1000000) {
            return new LuxuryCarOne();
        }

        return new LuxuryCarTwo();
    }
}
