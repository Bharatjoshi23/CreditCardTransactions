package com.example.transactions.entities;



import java.util.List;

public class MappingDataRequest {

    private List<Long> templateId;

    public List<Long> getTemplateId() {
        return templateId;
    }

    public void setTemplateId(List<Long> templateId) {
        this.templateId = templateId;
    }

    private Long cardProgramId;

    public Long getCardProgramId() {
        return cardProgramId;
    }
    public void setCardProgramId(Long cardProgramId) {
        this.cardProgramId = cardProgramId;
    }
}

