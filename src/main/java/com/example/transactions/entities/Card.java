package com.example.transactions.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Card {
    public Card(Long id, int cardId, CardProgram cardProgram ) {
        this.id = id;
        this.cardId = cardId;
        this.cardProgram=cardProgram;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cardId;


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

    public CardProgram getCardProgram() {
        return cardProgram;
    }

    public void setCardProgram(CardProgram cardProgram) {
        this.cardProgram = cardProgram;
    }

    @ManyToOne
    private CardProgram cardProgram;

    private  String programName;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Card() {
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne
    private Account account;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "card")
    private List<Transactions>transactions;

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
}
