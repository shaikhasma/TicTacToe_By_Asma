package com.lld.tic_tac_toe.model;

import com.lld.tic_tac_toe.constant.BotDifficultyLevel;
import com.lld.tic_tac_toe.factory.BotPlayingStrategyFactory;
import com.lld.tic_tac_toe.strategy.bot.BotPlayingStrategy;
import lombok.Data;

import static com.lld.tic_tac_toe.constant.BotDifficultyLevel.EASY;
import static com.lld.tic_tac_toe.constant.PlayerType.BOT;

@Data
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(String name, char symbol, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, BOT);
        this.botDifficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategyForDifficultyLevel(EASY);
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this, board);
    }


}
