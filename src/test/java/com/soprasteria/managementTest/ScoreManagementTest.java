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
    public void plus_10_per_fold_if_bet_0_fold_success_in_the_5th_set() {
        // Given
        int bet = 0;
        List<Integer> folds = generateFolds(0, 5);
        // When
        int score = scoreManagement.scoreCounter(bet, folds);
        // Then
        Assertions.assertEquals(50, score);
    }

    @Test
    public void minus_10_per_fold_if_bet_0_fold_failed_in_the_5th_set() {
        // Given
        int bet = 0;
        List<Integer> folds = new ArrayList<>();
        folds.add(1);
        folds.addAll(generateFolds(0, 4));
        // When
        int score = scoreManagement.scoreCounter(bet, folds);
        // Then
        Assertions.assertEquals(-50, score);
    }

    @Test
    public void plus_20_per_fold_won_if_bet_sup_to_0_fold_success_in_the_5th_set() {
        // Given
        int bet = 2;
        List<Integer> folds = new ArrayList<>();
        folds.addAll(generateFolds(0, 3));
        folds.addAll(generateFolds(1, 2));
        // When
        int score = scoreManagement.scoreCounter(bet, folds);
        // Then
        Assertions.assertEquals(40, score);
    }

    @Test
    public void minus_10_per_difference_between_bet_and_folds_won_if_bet_sup_to_0_failed_in_the_5th_set() {
        // Given
        int bet = 2;
        List<Integer> folds = new ArrayList<>();
        folds.addAll(generateFolds(1, 3));
        folds.addAll(generateFolds(0, 2));
        // When
        int score = scoreManagement.scoreCounter(bet, folds);
        // Then
        Assertions.assertEquals(-10, score);
    }

    private List<Integer> generateFolds(int foldsWon, int numberOfFolds) {
        List<Integer> folds = new ArrayList<>();
        for (int foldIndex = 0; foldIndex < numberOfFolds; foldIndex++) {
            folds.add(foldsWon);
        }
        return folds;
    }
}
