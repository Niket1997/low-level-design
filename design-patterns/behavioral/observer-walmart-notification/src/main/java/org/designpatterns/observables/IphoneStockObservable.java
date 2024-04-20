package org.designpatterns.observables;

import org.designpatterns.interfaces.observable.IInventoryStockObservable;
import org.designpatterns.interfaces.observer.INotificationAlertObserver;

import java.util.HashSet;
import java.util.Set;

public class IphoneStockObservable implements IInventoryStockObservable {
    Set<INotificationAlertObserver> observers;
    int iPhoneCount;

    public IphoneStockObservable() {
        this.observers = new HashSet<>();
        this.iPhoneCount = 0;
    }

    @Override
    public void add(INotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(INotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (INotificationAlertObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        int oldCount = this.iPhoneCount;
        this.iPhoneCount += newStockCount;

        if (oldCount == 0) {
            notifyObservers();
        }
    }

    @Override
    public int getStockCount() {
        return this.iPhoneCount;
    }
}
