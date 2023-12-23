package com.example.transactions.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MappingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long templateId;

    public  long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long cardProgramId;

    public Long getCardProgramId() {
        return cardProgramId;
    }
    public void setCardProgramId(Long cardProgramId) {
        this.cardProgramId = cardProgramId;
    }
}
