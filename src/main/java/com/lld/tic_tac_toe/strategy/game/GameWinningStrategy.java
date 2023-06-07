package com.lld.tic_tac_toe.strategy.game;

import com.lld.tic_tac_toe.model.Board;
import com.lld.tic_tac_toe.model.Cell;
import com.lld.tic_tac_toe.model.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Cell cell);
}
