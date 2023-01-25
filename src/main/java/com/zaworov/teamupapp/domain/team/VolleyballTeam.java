package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;

import java.util.List;

public class VolleyballTeam {
    private List<VolleyballPlayer> players;
    private int wins = 0;
    private boolean isWinner = false;

    public VolleyballTeam() {
    }

    public VolleyballTeam(List<VolleyballPlayer> players) {
        this.players = players;
    }

    public void increaseWins() {
        this.wins++;
    }

    public void wins() {
        this.isWinner = true;
    }

    public int getWins() {
        return wins;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public List<VolleyballPlayer> getPlayers() {
        return players;
    }
}
