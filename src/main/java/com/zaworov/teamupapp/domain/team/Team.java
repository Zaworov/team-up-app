package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.VolleyballSetScore;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players;
    private List<VolleyballSetScore> setScores = new ArrayList();
    public Team(List<Player> players){
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addSetScore(VolleyballSetScore setScore){
        setScores.add(setScore);
    }
}
