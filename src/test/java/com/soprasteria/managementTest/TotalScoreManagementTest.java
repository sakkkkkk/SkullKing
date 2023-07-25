package com.soprasteria.managementTest;

import com.soprasteria.enums.NameCardEnum;
import com.soprasteria.service.impl.TotalScoreServiceImpl;
import com.soprasteria.model.Card;
import com.soprasteria.model.Fold;
import com.soprasteria.model.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

public class TotalScoreManagementTest {
    private final TotalScoreServiceImpl totalScoreManagement = new TotalScoreServiceImpl();

    @Test
    public void total_score_30_bet_0_fold_success_AND_bonus_0() {
        // Given
        List<Fold> folds = new ArrayList<>();
        Player player = new Player(1, "Anoussak", 0, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        int scorePerFoldWithBet0Success = 10;
        assertThat(totalScore).isEqualTo(setNumber * scorePerFoldWithBet0Success);
    }
    
    @Test
    public void total_score_40_bet_1_fold_success_with_bonus_20_with_two_number_card_14_in_this_set() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 14));

        List<Fold> folds = new ArrayList<>();
        folds.add(0, new Fold(cards));

        Player player = new Player(1, "Anoussak", 1, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        int scorePerFoldWithBet1Success = 20;
        assertThat(totalScore).isEqualTo(player.getBet() * scorePerFoldWithBet1Success + 2 * 10);
    }

    @Test
    public void total_score_minus_10_bet_2_folds_failed() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 14));

        List<Fold> folds = new ArrayList<>();
        folds.add(0, new Fold(cards));

        Player player = new Player(1, "Anoussak", 2, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        int scorePerFoldBet2Failed = - 10;
        assertThat(totalScore).isEqualTo(abs(player.getBet() - setNumber) * scorePerFoldBet2Failed);
    }

    @Test
    public void total_score_140_with_bonus_80_first_fold_won_AND_bonus_20_second_fold_won_in_this_set() {
        // Given
        List<Card> cards1 = new ArrayList<>();
        cards1.add(0, new Card(NameCardEnum.Atout.name(), 14));
        cards1.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards1.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards1.add(3, new Card(NameCardEnum.SkullKing.name(), 0));

        List<Card> cards2 = new ArrayList<>();
        cards2.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards2.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards2.add(2, new Card(NameCardEnum.Green.name(), 14));
        cards2.add(3, new Card(NameCardEnum.Green.name(), 5));

        List<Fold> folds = new ArrayList<>();
        folds.add(0, new Fold(cards1));
        folds.add(1, new Fold(cards2));

        Player player = new Player(1, "Anoussak", 2, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        int scorePerFoldBet2Success = 20;
        int bonus = 2 * 30 + 20 + 2 * 10;
        assertThat(totalScore).isEqualTo(player.getBet() * scorePerFoldBet2Success + bonus);
    }
}