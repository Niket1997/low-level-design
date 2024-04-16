package org.designpatterns;

import org.designpatterns.interfaces.observable.IInventoryStockObservable;
import org.designpatterns.interfaces.observer.INotificationAlertObserver;
import org.designpatterns.observables.IphoneStockObservable;
import org.designpatterns.observers.EmailNotificationAlertObserver;
import org.designpatterns.observers.MobileNotificationAlertObserver;

public class Main {
    public static void main(String[] args) {

        IInventoryStockObservable iphoneStockObservable = new IphoneStockObservable();

        INotificationAlertObserver emailNotificationAlertObserverOne = new EmailNotificationAlertObserver(iphoneStockObservable, "abc@gmail.com");
        INotificationAlertObserver emailNotificationAlertObserverTwo = new EmailNotificationAlertObserver(iphoneStockObservable, "bcd@gmail.com");
        INotificationAlertObserver mobileNotificationAlertObserverTwo = new MobileNotificationAlertObserver(iphoneStockObservable, "+91 9900990099");

        iphoneStockObservable.add(emailNotificationAlertObserverOne);
        iphoneStockObservable.add(emailNotificationAlertObserverTwo);
        iphoneStockObservable.add(mobileNotificationAlertObserverTwo);

        iphoneStockObservable.setStockCount(100);
    }
}