package com.example.transactions.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Template {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String templateName;
    private String feeEvent;
    private String feeVariable;

    public Template() {
    }

    private String feeFrequency;
    private String feeSubEvent;
    private String templateType;
    private String calculationType;
    private Double feeValue;
    private String groupingCondition;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "template")
    private List<GivenRange> feeRanges;


    public String getFeeVariable() {
        return feeVariable;
    }

    public void setFeeVariable(String feeVariable) {
        this.feeVariable = feeVariable;
    }

    public String getFeeFrequency() {
        return feeFrequency;
    }

    public void setFeeFrequency(String feeFrequency) {
        this.feeFrequency = feeFrequency;
    }

    public String getFeeSubEvent() {
        return feeSubEvent;
    }

    public void setFeeSubEvent(String feeSubEvent) {
        this.feeSubEvent = feeSubEvent;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public List<GivenRange> getFeeRanges() {
        return feeRanges;
    }

    public void setFeeRanges(List<GivenRange> feeRanges) {
        this.feeRanges = feeRanges;
    }

    public Double getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(Double feeValue) {
        this.feeValue = feeValue;
    }

    public String getGroupingCondition() {
        return groupingCondition;
    }

    public void setGroupingCondition(String groupingCondition) {
        this.groupingCondition = groupingCondition;
    }

    public int getGroupingValue() {
        return groupingValue;
    }

    public void setGroupingValue(int groupingValue) {
        this.groupingValue = groupingValue;
    }

    public String getGroupingVariable() {
        return groupingVariable;
    }

    public void setGroupingVariable(String groupingVariable) {
        this.groupingVariable = groupingVariable;
    }

    public String getGroupingCalculationType() {
        return groupingCalculationType;
    }

    public void setGroupingCalculationType(String groupingCalculationType) {
        this.groupingCalculationType = groupingCalculationType;
    }

    public boolean isGstApplicable() {
        return gstApplicable;
    }

    public void setGstApplicable(boolean gstApplicable) {
        this.gstApplicable = gstApplicable;
    }

    public int getGstPercentage() {
        return gstPercentage;
    }

    public void setGstPercentage(int gstPercentage) {
        this.gstPercentage = gstPercentage;
    }

    public boolean isGstInclusive() {
        return gstInclusive;
    }

    public void setGstInclusive(boolean gstInclusive) {
        this.gstInclusive = gstInclusive;
    }

    private int groupingValue;
    private String groupingVariable;
    private String groupingCalculationType;
    private boolean gstApplicable;
    private int gstPercentage;
    private boolean gstInclusive;
    private int groupingPercent;
    private Integer surcharge;

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    public int getGroupingPercent() {
        return groupingPercent;
    }

    public void setGroupingPercent(int groupingPercent) {
        this.groupingPercent = groupingPercent;
    }

    public Template(String templateName, String feeEvent, String feeVariable, String feeFrequency,
                    String feeSubEvent, String templateType, String calculationType, Double feeValue,
                    String groupingCondition, int groupingValue, String groupingVariable,
                    String groupingCalculationType, boolean gstApplicable, int gstPercentage,
                    boolean gstInclusive) {
        this.templateName = templateName;
        this.feeEvent = feeEvent;
        this.feeVariable = feeVariable;
        this.feeFrequency = feeFrequency;
        this.feeSubEvent = feeSubEvent;
        this.templateType = templateType;
        this.calculationType = calculationType;
        this.feeValue = feeValue;
        this.groupingCondition = groupingCondition;
        this.groupingValue = groupingValue;
        this.groupingVariable = groupingVariable;
        this.groupingCalculationType = groupingCalculationType;
        this.gstApplicable = gstApplicable;
        this.gstPercentage = gstPercentage;
        this.gstInclusive = gstInclusive;
    }


    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFeeEvent() {
        return feeEvent;
    }

    public void setFeeEvent(String feeEvent) {
        this.feeEvent = feeEvent;
    }


}

