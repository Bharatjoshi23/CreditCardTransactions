package com.example.transactions.entities;

import jakarta.persistence.*;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cardId;
    private int accountNo;
    private String feeType;
    private double amountDeducted;
    private int currentBalance;
    private int gst;
    private boolean isGstInclusive;

    public boolean isGstInclusive() {
        return isGstInclusive;
    }

    public void setGstInclusive(boolean gstInclusive) {
        this.isGstInclusive = gstInclusive;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public double getAmountDeducted() {
        return amountDeducted;
    }

    public void setAmountDeducted(double amountDeducted) {
        this.amountDeducted = amountDeducted;
    }
}
