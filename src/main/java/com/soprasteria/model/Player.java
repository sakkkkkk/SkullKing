package com.soprasteria.model;

import java.util.List;

public class Player {
    private int id;
    private String name;
    private int bet;
    private int totalScore;
    private List<Fold> folds;

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

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public List<Fold> getFolds() {
        return folds;
    }

    public void setFolds(List<Fold> folds) {
        this.folds = folds;
    }

    public Player(int id, String name, int bet, List<Fold> folds) {
        this.id = id;
        this.name = name;
        this.bet = bet;
        this.folds = folds;
    }
}
