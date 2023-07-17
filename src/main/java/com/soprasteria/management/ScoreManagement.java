package com.soprasteria.management;


import java.util.List;

import static java.lang.Math.abs;

public class ScoreManagement {
    private static final int NUMBER_OF_FOLDS = 5;

    public int scoreCounter(int bet, List<Integer> folds) {
        int score = 0;
        int bonus = 0;
        if (bet > 0 && success(bet, folds)) {
            score = 20 * bet + bonus;
        } else if (bet > 0) {
            score = -10 * abs(bet - folds.stream().reduce(0, Integer::sum));
        } else if (bet == 0 && success(bet, folds)) {
            score = betEqualsZero(bet, folds) + bonus;
        } else { score = -betEqualsZero(bet, folds); }
        return score;
    }

    private boolean success(int bet, List<Integer > folds) {
        return folds.stream().reduce(0, Integer::sum) == bet;
    }

    private int betEqualsZero(int bet, List<Integer > folds) {
        return 10 * ScoreManagement.NUMBER_OF_FOLDS;
    }
}