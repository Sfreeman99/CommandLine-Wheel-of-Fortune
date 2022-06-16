package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    final List<Player> players = new ArrayList<>(5);
    final Random rand = new Random();
    public int PLAYER_COUNT;
    public boolean START_GAME = false;
    public int PLAYER_TURN = 0;
    final int BANKRUPT = 0;
    public void addPlayer(Player... players) {
        for (Player player : players) {
            this.players.add(player);
            PLAYER_COUNT++;
        }
        if (PLAYER_COUNT > 1) {
            START_GAME = true;
        }
    }

    public String getPlayerName() {
        return this.players.get(PLAYER_TURN).name;
    }

    public int spinWheel() {
        int max = 10;
        int min = 0;
        int[] wheelNumbers = {100, 200, 300,350,250, 400, 500, 600, 700, 800, 900};
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return wheelNumbers[randomNum];
    }

    public void isBankrupt(int wheelNumber) {
        if (wheelNumber == 250 || wheelNumber == 350) {
            this.players.get(PLAYER_TURN).setScore(BANKRUPT);
        }
    }
}
