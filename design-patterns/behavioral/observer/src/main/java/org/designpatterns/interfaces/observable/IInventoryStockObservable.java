package org.designpatterns.interfaces.observable;

import org.designpatterns.interfaces.observer.INotificationAlertObserver;

public interface IInventoryStockObservable {
    void add(INotificationAlertObserver observer);

    void remove(INotificationAlertObserver observer);

    void notifyObservers();

    void setStockCount(int newStockCount);

    int getStockCount();
}
