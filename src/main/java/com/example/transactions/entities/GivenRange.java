package com.example.transactions.entities;

import jakarta.persistence.*;

@Entity
public class GivenRange {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int startRange;
    private int endRange;

    private String calculationType;

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public GivenRange(Long id, int startRange, int endRange, String feeVariable,
                      int fee, Template template, String calculationType) {
        this.id = id;
        this.calculationType=calculationType;
        this.startRange = startRange;
        this.endRange = endRange;
        this.feeVariable = feeVariable;
        this.fee = fee;
        this.template = template;
    }

    private String feeVariable;


    public String getFeeVariable() {
        return feeVariable;
    }

    public void setFeeVariable(String feeVariable) {
        this.feeVariable = feeVariable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GivenRange() {
    }

    public int getStartRange() {
        return startRange;
    }

    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public void setEndRange(int endRange) {
        this.endRange = endRange;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    private int fee;
    @ManyToOne
    private Template template;
}
