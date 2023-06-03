package org.example;

/*
* Contains the game rules and logic.
* It determines the winner based on the moves chosen by the players.*/
public class GameLogic {

    /**
     * Determines the winner of the game based on the moves played by the player and the CPU.
     *
     * @param playerMove The move played by the player.
     * @param cpuMove    The move played by the CPU.
     * @return A string indicating the result of the game: "WIN" if the player wins, "LOSS" if the player loses, or "TIE" if it's a tie.
     */
    public String determineWinner(Moves playerMove, Moves cpuMove) {
        if (playerMove == cpuMove) {
            return "TIE";
        } else if (playerMove.equals(Moves.ROCK) && cpuMove.equals(Moves.PAPER) ||
                    playerMove.equals(Moves.PAPER) && cpuMove.equals(Moves.SCISSORS) ||
                    playerMove.equals(Moves.SCISSORS) && cpuMove.equals(Moves.ROCK)) {
            return "LOSS";
        } else {
            return "WIN";
        }
    }
}
