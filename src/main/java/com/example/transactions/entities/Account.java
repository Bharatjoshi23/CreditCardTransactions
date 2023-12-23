package com.example.transactions.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "account" )
    private List<Card> cards;

    private int accountNo;

    private int tad;
    private int mad;

    public Account(Long id, int accountNo, int tad, int mad, int balance) {
        this.id = id;
        this.accountNo = accountNo;
        this.tad = tad;
        this.mad = mad;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getTad() {
        return tad;
    }

    public void setTad(int tad) {
        this.tad = tad;
    }

    public int getMad() {
        return mad;
    }

    public void setMad(int mad) {
        this.mad = mad;
    }

    public Account() {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance;
}
