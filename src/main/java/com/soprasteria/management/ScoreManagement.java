package com.soprasteria.management;

import static java.lang.Math.abs;

public class ScoreManagement {
    public int scoreCounter(int bet, int foldsWon, int setNumber) {
        int score;

        if (bet > 0 && bet == foldsWon) {
            score = 20 * bet;
        } else if (bet > 0) {
            score = -10 * abs(bet - foldsWon);
        } else if (bet == 0 && bet == foldsWon) {
            score = 10 * setNumber;
        } else {
            score = -10 * setNumber;
        }

        return score;
    }
}