package com.soprasteria.model;

import java.util.List;

public class Player {
    private int id;
    private String name;
    private int bet;
    private int totalScore;
    private List<List<Card>> folds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int setTotalScore(int totalScore) {
        this.totalScore = totalScore;
        return totalScore;
    }

    public List<List<Card>> getFolds() {
        return folds;
    }

    public void setFolds(List<List<Card>> folds) {
        this.folds = folds;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
