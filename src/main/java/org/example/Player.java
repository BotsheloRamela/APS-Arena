package org.example;

import java.util.Scanner;

/**
 * Represents a player in the game.
 * It has properties such as name and points.
 * It provides methods to get the player's move and update their points.*/
public class Player {
    String username;
    int playerPoints;
    public Player() {
        playerPoints = 0;
        username = promptUsername();
    }

    /**
     * Prompts the player to enter their username.
     * @return The username entered by the player.
     */
    public String promptUsername() {
        Scanner userInput = new Scanner((System.in));
        System.out.println("What's your username?");
        return userInput.nextLine();
    }
}
