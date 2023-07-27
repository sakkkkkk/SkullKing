package com.soprasteria.service.impl;

import com.soprasteria.model.Player;
import com.soprasteria.service.TotalScoreService;

public class TotalScoreServiceImpl implements TotalScoreService {

    private final ScoreServiceImpl scoreService = new ScoreServiceImpl();
    private final BonusScoreServiceImpl bonusScoreService = new BonusScoreServiceImpl();

    public int totalScore(Player player, int setNumber) {
        int bonus = 0;

        int score = scoreService.scoreCounter(player.getBet(), player.getFolds().size(), setNumber);

        if (player.getBet() > 0 && player.getBet() == player.getFolds().size()) {
            for (int foldIndex = 0; foldIndex < player.getFolds().size(); foldIndex++) {
                bonus += bonusScoreService.countBonus(player.getFolds().get(foldIndex).getCards());
            }
        }

        return player.setTotalScore(score + bonus);
    }
}
