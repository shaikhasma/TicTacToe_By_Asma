package com.lld.tic_tac_toe.model;

import com.lld.tic_tac_toe.constant.CellStatus;
import com.lld.tic_tac_toe.constant.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

import static com.lld.tic_tac_toe.constant.CellStatus.EMPTY;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Move decideMove(Board board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Row :");
        int row = scanner.nextInt();

        System.out.println("Select Col :");
        int col = scanner.nextInt();

       return  new Move(this, new Cell(row, col,this, EMPTY));
    }

}
