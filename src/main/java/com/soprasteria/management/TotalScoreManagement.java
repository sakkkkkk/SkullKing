package com.soprasteria.management;

import com.soprasteria.model.Card;
import com.soprasteria.model.Player;

import java.util.List;

public class TotalScoreManagement {

    private final ScoreManagement scoreManagement = new ScoreManagement();
    private final BonusScoreManagement bonusManagement = new BonusScoreManagement();

    public int totalScore(Player player, int setNumber) {
        int bonus = 0;
        if (!player.getFolds().isEmpty()) {
            for (int foldIndex = 0; foldIndex < player.getFolds().size(); foldIndex++) {
                bonus += bonusManagement.countBonus(player.getFolds().get(foldIndex));
            }
        }
        int score = scoreManagement.scoreCounter(player.getBet(), player.getFolds().size(), setNumber);
        return player.setTotalScore(score + bonus);
    }
}
