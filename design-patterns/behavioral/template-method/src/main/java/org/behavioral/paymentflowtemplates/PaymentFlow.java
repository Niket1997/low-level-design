package org.behavioral.paymentflowtemplates;

public abstract class PaymentFlow {
    protected abstract void validateRequest();

    protected abstract void calculateFees();

    protected abstract void debitAmount();

    protected abstract void creditAmount();

    public final void sendMoney() {
        // 1. validate the payment
        validateRequest();

        // 2. calculate Fees
        calculateFees();

        // 3. debit source account
        debitAmount();

        // 4. credit beneficiary account
        creditAmount();
    }
}
