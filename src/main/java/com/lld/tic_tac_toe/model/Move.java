package com.lld.tic_tac_toe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Move {
    private Player player;
    private Cell cell;

}
