package com.soprasteria.managementTest;

import com.soprasteria.management.ScoreManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ScoreManagement.class)
public class ScoreManagementTest {
    private final ScoreManagement scoreManagement = new ScoreManagement();

    @Test
    public void plus_10_per_fold_if_bet_0_fold_success() {
        // Given
        int bet = 0;
        int foldsWon = 0;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        Assertions.assertEquals(50, score);
    }

    @Test
    public void minus_10_per_fold_if_bet_0_fold_failed() {
        // Given
        int bet = 0;
        int foldsWon = 1;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        Assertions.assertEquals(-50, score);
    }

    @Test
    public void plus_20_per_fold_won_if_bet_sup_to_0_fold_success_in_the_5th_set() {
        // Given
        int bet = 2;
        int foldsWon = 2;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        Assertions.assertEquals(40, score);
    }

    @Test
    public void minus_10_per_difference_between_bet_and_folds_won_if_bet_sup_to_0_failed_in_the_5th_set() {
        // Given
        int bet = 2;
        int foldsWon = 1;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        Assertions.assertEquals(-10, score);
    }

}
