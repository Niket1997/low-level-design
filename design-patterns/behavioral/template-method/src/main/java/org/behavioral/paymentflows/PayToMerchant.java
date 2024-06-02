package org.behavioral.paymentflows;

import org.behavioral.paymentflowtemplates.PaymentFlow;

public class PayToMerchant extends PaymentFlow {
    @Override
    public void validateRequest() {
        System.out.println("validate payment to merchant request");
    }

    @Override
    public void calculateFees() {
        System.out.println("calculating fees for merchant money transfer");
    }

    @Override
    public void debitAmount() {
        System.out.println("debiting the customer's account");
    }

    @Override
    public void creditAmount() {
        System.out.println("crediting the merchant's account");
    }
}
