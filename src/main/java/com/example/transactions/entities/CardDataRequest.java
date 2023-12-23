package com.example.transactions.entities;

public class CardDataRequest {
    private int cardId;
    private String eventType;

    private String feeSubEvent;

    public String getFeeSubEvent() {
        return feeSubEvent;
    }

    public void setFeeSubEvent(String feeSubEvent) {
        this.feeSubEvent = feeSubEvent;
    }

    private String programName;


    public String getProgramName() {
        return programName;
    }


    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
