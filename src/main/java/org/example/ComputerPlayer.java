package org.example;

import java.util.Random;

/*
* Extends the Player class and represents the computer player in single-player mode.
* It implements a strategy to generate a random move for the computer.*/
public class ComputerPlayer {
    private int cpuPoints = 0;

    private Moves generateCPUMove() {
        Moves[] moves = Moves.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}
