package org.designpatterns.observers;

import org.designpatterns.interfaces.observable.IInventoryStockObservable;
import org.designpatterns.interfaces.observer.INotificationAlertObserver;

public class EmailNotificationAlertObserver implements INotificationAlertObserver {
    IInventoryStockObservable observable;
    String emailId;

    public EmailNotificationAlertObserver(IInventoryStockObservable observable, String emailId) {
        this.observable = observable;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendEmailCommunication(observable.getStockCount());
    }

    private void sendEmailCommunication(int stockCount) {
        System.out.println("Email communication sent to user with email id: " + emailId + " for " + stockCount + " stocks availability.");
    }
}
