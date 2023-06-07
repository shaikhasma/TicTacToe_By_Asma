package com.lld.tic_tac_toe.strategy.game;

import com.lld.tic_tac_toe.model.Board;
import com.lld.tic_tac_toe.model.Cell;
import com.lld.tic_tac_toe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWin implements GameWinningStrategy{

    private List<HashMap<Character, Integer>> rowSymbolCount = new ArrayList<>();
    private List<HashMap<Character, Integer>> colSymbolCount = new ArrayList<>();
    private HashMap<Character, Integer> topLeftDiagonal = new HashMap<>();
    private HashMap<Character, Integer> topRightDiagonal = new HashMap<>();
    private int dimension;

    public OrderOneGameWin(int dimension){
        this.dimension = dimension;
        for (int i = 0; i< dimension; i++){
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Cell cell) {
        int row = cell.getRow();
        int col = cell.getColumn();
        char symbol = cell.getPlayer().getSymbol();

        updateRowMap(row,col,symbol);
        updateColMap(row, col, symbol);
        updateTopLeftDiagonalMap(row,col,symbol);
        updateTopRightDiagonalMap(row, col, symbol);

        if( isWinByRow(row, symbol) || isWinByCol(col, symbol)) {
            return true;
        }
        if(isTopLeftDiagonalCell(row, col) && isWinByLeftDiagonal(symbol)){
            return true;
        }
        if(isTopRightDiagonalCell(row, col) && isWinByRightDiagonal(symbol)){
            return true;
        }

        return false;
    }

    boolean isWinByRow(int row, char symbol){
        return rowSymbolCount.get(row).get(symbol) == dimension;
    }
    boolean isWinByCol(int col, char symbol){
        return colSymbolCount.get(col).get(symbol) == dimension;
    }

    boolean isWinByLeftDiagonal(char symbol){
        return topLeftDiagonal.get(symbol) == dimension;
    }

    boolean isWinByRightDiagonal(char symbol){
        return topRightDiagonal.get(symbol) == dimension;
    }
    private void updateRowMap(int row, int col, char symbol){
        if(!rowSymbolCount.get(row).containsKey(symbol)) {
            rowSymbolCount.get(row).put(symbol, 0);
        }

        rowSymbolCount.get(row).put(
                    symbol,
                    rowSymbolCount.get(row).get(symbol) + 1
            );
    }

    private void updateColMap(int row, int col, char symbol){
        if(!colSymbolCount.get(col).containsKey(symbol)) {
            colSymbolCount.get(col).put(symbol, 0);
        }

        colSymbolCount.get(col).put(
                    symbol,
                    colSymbolCount.get(col).get(symbol) + 1
        );
    }

    private void updateTopLeftDiagonalMap(int row, int col, char symbol){
        if(isTopLeftDiagonalCell(row, col)){
            if(!topLeftDiagonal.containsKey(symbol)){
                topLeftDiagonal.put(symbol, 0);
            }
            topLeftDiagonal.put(
                        symbol,
                        topLeftDiagonal.get(symbol) + 1
            );
        }
    }

    private void updateTopRightDiagonalMap(int row, int col, char symbol){
        if(isTopRightDiagonalCell(row, col)){
            if(!topRightDiagonal.containsKey(symbol)){
                topRightDiagonal.put(symbol,0);
            }

            topRightDiagonal.put(
                        symbol,
                        topRightDiagonal.get(symbol) + 1
            );
        }
    }
    private boolean isTopLeftDiagonalCell(int row, int col){
        return row == col;
    }

    private boolean isTopRightDiagonalCell(int row, int col){
        return row + col == dimension - 1;
    }
}
