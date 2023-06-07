package com.lld.tic_tac_toe.factory;


import com.lld.tic_tac_toe.constant.BotDifficultyLevel;
import com.lld.tic_tac_toe.strategy.bot.BotPlayingStrategy;
import com.lld.tic_tac_toe.strategy.bot.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        return new RandomBotPlayingStrategy();
    }
}
