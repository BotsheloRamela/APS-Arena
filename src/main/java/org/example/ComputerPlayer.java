package org.example;

import java.util.Random;

/*
* Extends the Player class and represents the computer player in single-player mode.
* It implements a strategy to generate a random move for the computer.*/
public class ComputerPlayer {
    private int cpuPoints = 0;

    public int getCpuPoints() {
        return cpuPoints;
    }

    public void incrementPoints() {
        cpuPoints++;
    }

    /**
     * Generates a random move for the computer player.
     *
     * @return A random move from the Moves enum.
     */
    public Moves generateCPUMove() {
        Moves[] moves = Moves.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}
