package com.lld.tic_tac_toe.model;

import com.lld.tic_tac_toe.constant.GameStatus;
import com.lld.tic_tac_toe.exception.InvalidGameException;
import com.lld.tic_tac_toe.strategy.game.GameWinningStrategy;
import com.lld.tic_tac_toe.strategy.game.OrderOneGameWin;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.lld.tic_tac_toe.constant.CellStatus.EMPTY;
import static com.lld.tic_tac_toe.constant.CellStatus.FILLED;
import static com.lld.tic_tac_toe.constant.GameStatus.ENDED;
import static com.lld.tic_tac_toe.constant.GameStatus.IN_PROGRESS;
import static com.lld.tic_tac_toe.constant.NumberConstant.THREE;

@Data
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;
    private  GameWinningStrategy gameWinningStrategy;

    public void undo(){
        Player currentPlayer = players.get(nextPlayerIndex);
        Move currentMove = moves.get(moves.size() - 1);

        moves.remove(moves.size() - 1);
        nextPlayerIndex --;
        currentPlayer = players.get(nextPlayerIndex);

        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getColumn();
        board.getBoard().get(row).get(col).setCellStatus(EMPTY);
        board.getBoard().get(row).get(col).setPlayer(currentPlayer);

        gameStatus = IN_PROGRESS;
    }
    public static GameBuilder getGameBuilder(){
        return new GameBuilder();
    }


    public void makeNextMove(){
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("It's " + currentPlayer.getName() + " turn");

        Move move = currentPlayer.decideMove(board);
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        board.getBoard().get(row).get(col).setCellStatus(FILLED);
        board.getBoard().get(row).get(col).setPlayer(currentPlayer);
        moves.add(move);

        //Check Winner if player win then change game status as ended and return from here it self
        if(gameWinningStrategy.checkWinner(move.getCell())){
            gameStatus = ENDED;
            winner = players.get(nextPlayerIndex);
        }
        nextPlayerIndex++;
        nextPlayerIndex %= players.size();
    }

    public static class GameBuilder {
        private int dimension;
        private List<Player> players;

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public static GameBuilder getGameBuilder(){
            return new GameBuilder();
        }

        private boolean validGame() throws InvalidGameException {
            if (this.dimension < THREE.getName()) {
                throw new InvalidGameException("Board Dimension can not be be less then 3");
            }
            if (this.players.size() != this.dimension - 1) {
                throw new InvalidGameException("Number of Player should be Dimension - 1");
            }
            //Validate two player should not have same symbol
            // There should not be more that 1 Bot
            return true;
        }

        public Game build() throws InvalidGameException {
            try {
                validGame();
            } catch (Exception exception) {
                throw new InvalidGameException(exception.getMessage());
            }
            Game game = new Game();
            game.setGameStatus(IN_PROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setBoard(new Board(dimension));
            game.setNextPlayerIndex(0);
            //set Game winning strategy
            game.setGameWinningStrategy(new OrderOneGameWin(dimension));
            return game;
        }
    }
}
