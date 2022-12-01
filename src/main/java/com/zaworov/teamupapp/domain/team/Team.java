package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.Player;

import java.util.List;

public class Team {
    private List<Player> players;
    public Team(List<Player> players){
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
