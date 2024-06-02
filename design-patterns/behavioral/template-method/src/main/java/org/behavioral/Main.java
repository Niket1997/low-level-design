package org.behavioral;

import org.behavioral.paymentflows.PayToFriend;
import org.behavioral.paymentflows.PayToMerchant;
import org.behavioral.paymentflowtemplates.PaymentFlow;

public class Main {
    public static void main(String[] args) {
        PaymentFlow payToFriend = new PayToFriend();
        payToFriend.sendMoney();

        System.out.println();

        PaymentFlow payToMerchant = new PayToMerchant();
        payToMerchant.sendMoney();
    }
}