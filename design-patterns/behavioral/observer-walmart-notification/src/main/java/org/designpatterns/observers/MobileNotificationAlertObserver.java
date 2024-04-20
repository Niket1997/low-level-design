package org.designpatterns.observers;

import org.designpatterns.interfaces.observable.IInventoryStockObservable;
import org.designpatterns.interfaces.observer.INotificationAlertObserver;

public class MobileNotificationAlertObserver implements INotificationAlertObserver {
    IInventoryStockObservable observable;
    String mobileNumber;

    public MobileNotificationAlertObserver(IInventoryStockObservable observable, String mobileNumber) {
        this.observable = observable;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void update() {
        sendMobileCommunication(observable.getStockCount());
    }

    private void sendMobileCommunication(int stockCount) {
        System.out.println("Mobile communication sent to user with mobile number: " + mobileNumber + " for " + stockCount + " stocks availability.");
    }
}
