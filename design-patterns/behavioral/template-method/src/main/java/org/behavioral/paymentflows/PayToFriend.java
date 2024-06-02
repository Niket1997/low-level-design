package org.behavioral.paymentflows;

import org.behavioral.paymentflowtemplates.PaymentFlow;

public class PayToFriend extends PaymentFlow {
    @Override
    public void validateRequest() {
        System.out.println("validating payment request to friend");
    }

    @Override
    public void calculateFees() {
        System.out.println("no fees for payment to friend");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit amount for payment to friend");
    }

    @Override
    public void creditAmount() {
        System.out.println("credit amount for payment to friend");
    }
}
