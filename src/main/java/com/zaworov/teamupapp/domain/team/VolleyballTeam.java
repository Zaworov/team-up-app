package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.VolleyballSetScore;

import java.util.ArrayList;
import java.util.List;

public class VolleyballTeam {
    private List<VolleyballPlayer> players;
    private List<VolleyballSetScore> setScores = new ArrayList();
    public VolleyballTeam(List<VolleyballPlayer> players){
        this.players = players;
    }

    public List<VolleyballPlayer> getPlayers() {
        return players;
    }

    public void addSetScore(VolleyballSetScore setScore){
        setScores.add(setScore);
    }
}
