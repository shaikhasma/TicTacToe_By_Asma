package com.lld.tic_tac_toe.controller;

import com.lld.tic_tac_toe.constant.GameStatus;
import com.lld.tic_tac_toe.exception.InvalidGameException;
import com.lld.tic_tac_toe.model.Game;
import com.lld.tic_tac_toe.model.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        try{
            return Game.getGameBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .build();
        } catch (InvalidGameException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void showBoard(Game game){
        System.out.println("*******Current Status of board*******");
        game.getBoard().showBoard();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void executeNextMove(Game game){
      game.makeNextMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void undo(Game game){
        game.undo();
    }
}
