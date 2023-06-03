package org.example;

/*
* Contains the game rules and logic.
* It determines the winner based on the moves chosen by the players.*/
public class GameLogic {

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
