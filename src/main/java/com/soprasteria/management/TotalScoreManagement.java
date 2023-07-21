package com.soprasteria.management;

import com.soprasteria.model.Player;

public class TotalScoreManagement {

    private final ScoreManagement scoreManagement = new ScoreManagement();
    private final BonusScoreManagement bonusManagement = new BonusScoreManagement();

    public int totalScore(Player player, int setNumber) {
        int bonus = 0;
        if (player.getBet() > 0 && player.getBet() == player.getFolds().size()) {
            for (int foldIndex = 0; foldIndex < player.getFolds().size(); foldIndex++) {
                bonus += bonusManagement.countBonus(player.getFolds().get(foldIndex).getCards());
            }
        }
        int score = scoreManagement.scoreCounter(player.getBet(), player.getFolds().size(), setNumber);
        return player.setTotalScore(score + bonus);
    }
}
