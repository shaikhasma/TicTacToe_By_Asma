package com.lld.tic_tac_toe;

import com.lld.tic_tac_toe.controller.GameController;
import com.lld.tic_tac_toe.model.Bot;
import com.lld.tic_tac_toe.model.Game;
import com.lld.tic_tac_toe.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.lld.tic_tac_toe.constant.BotDifficultyLevel.EASY;
import static com.lld.tic_tac_toe.constant.GameStatus.DRAW;
import static com.lld.tic_tac_toe.constant.GameStatus.IN_PROGRESS;
import static com.lld.tic_tac_toe.constant.PlayerType.HUMAN;

//@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TicTacToeApplication.class, args);
		System.out.println("Welcome! This is tic Tac Toe Game...");
		Scanner scanner = new Scanner(System.in);
		GameController gameController = new GameController();

		/* Creating Tic Tac Toe Game */
		System.out.println("What should be the dimension of game?");
		int dimension = scanner.nextInt();

		System.out.println("Will there be any bot? y/n");
		String isBot = scanner.next();

		List<Player> players = new ArrayList<>();

		int totalPlayer = dimension - 1;
		if(isBot.equalsIgnoreCase("Y")){
			totalPlayer = dimension - 2;
		}

		for(int i = 0; i < totalPlayer; i++){
			System.out.println("Name of Player "+i);
			String playerName = scanner.next();

			System.out.println("Symbol of Player "+i);
			String playerSymbol = scanner.next();

			players.add(new Player(playerName, playerSymbol.charAt(0), HUMAN));
		}

		if ("y".equals(isBot)) {
			System.out.println("What is the name of bot?");
			String playerName = scanner.next();

			System.out.println("What is the char of bot?");
			String playerSymbol = scanner.next();

			players.add(new Bot(playerName, playerSymbol.charAt(0), EASY));
		}


		Game game = gameController.createGame(dimension,players);


		/* Do till Game is not ended  */
		while(IN_PROGRESS.equals(game.getGameStatus())){
			//Current Status of Game
			gameController.showBoard(game);

			System.out.println("Does you want to undo? y/n");
			String input = scanner.next();

			if ("y".equalsIgnoreCase(input)) {
				gameController.undo(game);
			} else {
				gameController.executeNextMove(game);
			}
		}


		System.out.println("*****Game Ended*****");
		if (!DRAW.equals(gameController.getGameStatus(game))) {
			System.out.println("Winner is: ." + gameController.getWinner(game).getName());
		}
	}


}
