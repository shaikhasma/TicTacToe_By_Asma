package com.lld.tic_tac_toe.model;

import com.lld.tic_tac_toe.constant.CellStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.lld.tic_tac_toe.constant.CellStatus.EMPTY;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {
    private int row;
    private int column;
    private Player player;
    private CellStatus cellStatus;
    public Cell(int row, int column){
        this.row = row;
        this.column = column;
        cellStatus = EMPTY;
    }
}
