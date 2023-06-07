package com.lld.tic_tac_toe.strategy.bot;


import com.lld.tic_tac_toe.model.Board;
import com.lld.tic_tac_toe.model.Move;
import com.lld.tic_tac_toe.model.Player;

public interface BotPlayingStrategy {

    Move decideMove(Player player, Board board);
}
