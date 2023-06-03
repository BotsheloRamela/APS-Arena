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

    private void setGameMode() {
        Scanner userInput = new Scanner((System.in));
        System.out.println("Select Game Mode!\n");
        System.out.println("1. Single-player");
        System.out.println("2. Multiplayer\n");

        String input = userInput.nextLine();
        if (input.equalsIgnoreCase("1")) {
            singlePlayer = true;
        } else if (input.equalsIgnoreCase("2")) {
            singlePlayer = false;
        } else {
            setGameMode();
        }
    }
}
