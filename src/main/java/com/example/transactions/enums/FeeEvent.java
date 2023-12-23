package com.example.transactions.enums;

public enum FeeEvent {
    CARD_ISSUANCE("Card Issuance"),
    FIRST_TRANSACTION("First Transaction"),
    CARD_CLOSURE("Card Closure"),
    CARD_ACTIVATION("Card Activation"),
    CARD_BILLING("Card Billing"),
    PAYMENT_DUE_DATE("Payment Due Date"),
    TRANSACTION("Transaction"),
    EMI_CONVERSION("EMI Conversion"),
    REWARD_REDEMPTION("Reward Redemption"),
    BOUNCE_PAYMENT("Bounce Payment"),
    CASH_PAYMENT("Cash Payment"),
    CREDIT_LIMIT_INCREASE("Credit Limit Increase"),
    RETURN_PAYMENT("Return Payment"),
    BALANCE_TRANSFER("Balance Transfer"),
    OVER_LIMIT("Over Limit");

    private final String name;

    FeeEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

