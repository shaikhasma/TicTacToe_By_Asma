package com.lld.tic_tac_toe.model;

import com.lld.tic_tac_toe.constant.CellStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.lld.tic_tac_toe.constant.CellStatus.EMPTY;

@Data
@AllArgsConstructor
public class Board {
    private List<List<Cell>> board;

    public Board(int dimension) {
        board = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());

            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }


    public void showBoard(){

        for(int i = 0; i < board.size(); i++){
            for(int j = 0 ; j < board.size(); j++){
                if(EMPTY.equals(board.get(i).get(j).getCellStatus())){
                    System.out.print("|   |");
                }else{
                    System.out.print("| " + board.get(i).get(j).getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

}
