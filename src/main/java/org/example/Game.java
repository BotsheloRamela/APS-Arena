package org.example;

import java.util.Scanner;

/*
* Handles the overall flow of the game.
* It prompts the player for game mode selection, creates instances of other necessary classes, and orchestrates the gameplay.
*/
public class Game {
    boolean singlePlayer;
    public Game() {
        System.out.println("Welcome to RPS Arena!\n");
        setGameMode();
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
            new Player();
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
}
