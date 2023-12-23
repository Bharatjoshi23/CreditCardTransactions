package com.example.transactions.entities;

import java.util.List;

public class TemplateDataRequest {

    private String templateName;
    private String feeEvent;
    private String feeVariable;
    private String feeFrequency;
    private String feeSubEvent;
    private String templateType;
    private String calculationType;
    private Double feeValue;
    private String groupingCondition;

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
    public int getGroupingPercent() {
        return groupingPercent;
    }

    public void setGroupingPercent(int groupingPercent) {
        this.groupingPercent = groupingPercent;
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

    private int surcharge;

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    private List<GivenRange> feeRanges;

    public List<GivenRange> getFeeRanges() {
        return feeRanges;
    }

    public void setFeeRanges(List<GivenRange> feeRanges) {
        this.feeRanges = feeRanges;
    }
}
