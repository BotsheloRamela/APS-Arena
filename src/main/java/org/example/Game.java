package org.example;

import java.util.Scanner;

/*
* Handles the overall flow of the game.
* It prompts the player for game mode selection, creates instances of other necessary classes, and orchestrates the gameplay.
*/
public class Game {
    boolean singlePlayer;
    Player player;
    ComputerPlayer computerPlayer;
    GameLogic gameLogic;

    /*
    * Initializes the game by displaying a welcome message, setting the game mode,
    * creating instances of other necessary classes (Player, ComputerPlayer, and GameLogic), and starting the game.*/
    public Game() {
        System.out.println("Welcome to RPS Arena!\n");
        setGameMode();
        gameLogic = new GameLogic();
        startGame();
    }

    /**
     * Prompts the player to select the game mode (single-player or multiplayer).
     * Sets the 'singlePlayer' variable based on the user input.
     */
    private void setGameMode() {
        Scanner userInput = new Scanner((System.in));
        System.out.println("Select Game Mode!\n");
        System.out.println("1. Single-player");
        System.out.println("2. Multiplayer\n");

        String input = userInput.nextLine();
        if (input.equalsIgnoreCase("1")) {
            singlePlayer = true;
            System.out.println("You have selected Single-player mode!\n");
            player = new Player();
            computerPlayer = new ComputerPlayer();
        } else if (input.equalsIgnoreCase("2")) {
            singlePlayer = false;
        } else if (input.equalsIgnoreCase("exit")) {
            System.out.println("Exiting APS Arena...");
            System.exit(0);
        }
        else {
            setGameMode();
        }
    }

    /*
    * Handles the main game loop. It repeatedly prompts the player for their move, checks if the input is "exit" to exit the game,
    * converts the input to a Moves enum value, generates the opponent's move (either by the computer in single-player mode or by
    * the other player in multiplayer mode), determines the winner using GameLogic, updates the points for the players, and displays
    * the result and current points.*/
    private void startGame() {
        while (true) {
            System.out.println("Enter your move or type 'exit' to quit the game:");
            System.out.println("Moves: ROCK, PAPER, SCISSORS");
            String input = getPlayerInput();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting RPS Arena...");
                System.exit(0);
            }

            Moves playerMove = convertToMove(input);
            if (playerMove == null) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            Moves opponentMove;
            if (singlePlayer) {
                opponentMove = computerPlayer.generateCPUMove();
                System.out.println("\nComputer played: " + opponentMove);
            } else {
                opponentMove = player.getOpponent().getPlayerMove();
                System.out.println(player.getOpponent().getUsername() + " played: " + opponentMove);
            }

            String result = gameLogic.determineWinner(playerMove, opponentMove);
            System.out.println("Result: " + result);
            updatePoints(result);
        }
    }

    /*
    * Prompts the player to enter their move or type "exit" to quit the game and returns the input as a String.*/
    private String getPlayerInput() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine().toUpperCase();
    }

    /*
    * converts the input String to a corresponding Moves enum value. It tries to match the input with the available
    * Moves enum values (ROCK, PAPER, SCISSORS) and returns the matched enum value. If the input doesn't match any
    * enum value, it returns null.*/
    private Moves convertToMove(String input) {
        try {
            return Moves.valueOf(input);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /*
    * updates the points for the players based on the game result.
    * If the result is "WIN," it increments the player's points and displays a message indicating the player's win.
    * If the result is "LOSS," it increments the opponent's points (computer in single-player or the other player in multiplayer)
    * and displays a message indicating the opponent's win.
    * If the result is a tie, it displays a message indicating a tie. It then prints the current points for both players.*/
    private void updatePoints(String result) {
        if (result.equals("WIN")) {
            player.incrementPoints();
            System.out.println(player.getUsername() + " wins!");
        } else if (result.equals("LOSS")) {
            if (singlePlayer) {
                computerPlayer.incrementPoints();
                System.out.println("Computer wins!");
            } else {
                player.getOpponent().incrementPoints();
                System.out.println(player.getOpponent().getUsername() + " wins!");
            }
        } else {
            System.out.println("It's a tie!");
        }

        System.out.println("\nPoints:");
        System.out.println(player.getUsername() + ": " + player.getPlayerPoints());
        if (!singlePlayer) {
            System.out.println(player.getOpponent().getUsername() + ": " + player.getOpponent().getPlayerPoints());
        } else {
            System.out.println("Computer: " + computerPlayer.getCpuPoints());
        }
        System.out.println();
    }
}
