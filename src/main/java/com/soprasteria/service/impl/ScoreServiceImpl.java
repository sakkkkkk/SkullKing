package com.soprasteria.service.impl;

import com.soprasteria.service.ScoreService;

import static java.lang.Math.abs;

public class ScoreServiceImpl implements ScoreService {
    public int scoreCounter(int bet, int numberOfFoldsWon, int setNumber) {
        int score;

        if (bet > 0 && bet == numberOfFoldsWon) {
            score = 20 * bet;
        }
        else if (bet > 0) {
            score = -10 * abs(bet - numberOfFoldsWon);
        }
        else if (bet == 0 && bet == numberOfFoldsWon) {
            score = 10 * setNumber;
        }
        else {
            score = -10 * setNumber;
        }
        return score;
    }
}