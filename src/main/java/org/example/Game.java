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
            System.out.println("You have selected Single-player!\n");
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
            Moves playerMove = player.getPlayerMove();
            Moves opponentMove = null;
            if (singlePlayer) {
                opponentMove = computerPlayer.generateCPUMove();
                System.out.println("Computer played: " + opponentMove);
            }

            String result = gameLogic.determineWinner(playerMove, opponentMove);
            System.out.println("Result: " + result);
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

        System.out.println("Points:");
        System.out.println(player.getUsername() + ": " + player.getPlayerPoints());
        if (!singlePlayer) {
            System.out.println(player.getOpponent().getUsername() + ": " + player.getOpponent().getPlayerPoints());
        } else {
            System.out.println("Computer: " + computerPlayer.getCpuPoints());
        }
        System.out.println();
    }
}
