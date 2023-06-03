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


    private String getPlayerInput() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine().toUpperCase();
    }


    private Moves convertToMove(String input) {
        try {
            return Moves.valueOf(input);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }


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
