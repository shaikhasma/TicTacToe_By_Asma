package com.lld.tic_tac_toe.strategy.bot;

import com.lld.tic_tac_toe.constant.CellStatus;
import com.lld.tic_tac_toe.model.Board;
import com.lld.tic_tac_toe.model.Cell;
import com.lld.tic_tac_toe.model.Move;
import com.lld.tic_tac_toe.model.Player;

import static com.lld.tic_tac_toe.constant.CellStatus.EMPTY;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Player player, Board board) {
        for (int row = 0; row < board.getBoard().size(); row++){
            for(int col = 0; col < board.getBoard().size(); col++){

                Cell cell = board.getBoard().get(row).get(col);
                if(EMPTY.equals(board.getBoard().get(row).get(col).getCellStatus())){
                    return new Move(player, cell);
                }
            }
        }
        return null;
    }
}
