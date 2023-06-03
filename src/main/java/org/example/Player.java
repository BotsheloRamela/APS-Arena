package org.example;

import java.util.Scanner;

/**
 * Represents a player in the game.
 * It has properties such as name and points.
 * It provides methods to get the player's move and update their points.*/
public class Player {
    String username;
    int playerPoints;
    private Player opponent;
    public Player() {
        this.playerPoints = 0;
        this.username = promptUsername();
        System.out.println("Hello " + username + "!\n");
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return opponent;
    }

    /**
     * Prompts the player to enter their username.
     *
     * @return The username entered by the player.
     */
    public String promptUsername() {
        Scanner userInput = new Scanner((System.in));
        System.out.println("What's your username?");
        return userInput.nextLine();
    }

    /**
     * Prompts the player to enter their move (Rock, Paper, or Scissors).
     * If the user input is not valid, the player is prompted again until a valid move is entered.
     *
     * @return The valid move entered by the player.
     */
    public Moves getPlayerMove() {
        System.out.println("Rock, Paper or Scissors?\n");
        Scanner userInput = new Scanner((System.in));
        String input = userInput.nextLine().toUpperCase();

        if (input.equals(Moves.ROCK.toString()) || input.equals(Moves.PAPER.toString()) || input.equals(Moves.SCISSORS.toString())) {
            return Moves.valueOf(input);
        } else {
            System.out.println("Invalid move. Please try again.");
            return getPlayerMove();
        }
    }
}
