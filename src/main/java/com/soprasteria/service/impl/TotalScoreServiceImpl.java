package com.soprasteria.service.impl;

import com.soprasteria.model.Player;
import com.soprasteria.service.TotalScoreService;

public class TotalScoreServiceImpl implements TotalScoreService {

    private final ScoreServiceImpl scoreManagement = new ScoreServiceImpl();
    private final BonusScoreServiceImpl bonusManagement = new BonusScoreServiceImpl();

    public int totalScore(Player player, int setNumber) {
        int bonus = 0;

        int score = scoreManagement.scoreCounter(player.getBet(), player.getFolds().size(), setNumber);

        if (player.getBet() > 0 && player.getBet() == player.getFolds().size()) {
            for (int foldIndex = 0; foldIndex < player.getFolds().size(); foldIndex++) {
                bonus += bonusManagement.countBonus(player.getFolds().get(foldIndex).getCards());
            }
        }

        return player.setTotalScore(score + bonus);
    }
}
