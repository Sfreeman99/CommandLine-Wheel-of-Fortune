package org.example;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>(5);
    public int PLAYER_COUNT;
    public boolean START_GAME = false;
    public int PLAYER_TURN = 0;
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
}
