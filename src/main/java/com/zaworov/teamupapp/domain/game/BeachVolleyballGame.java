package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.PlayerInterface;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.team.TeamInterface;
import com.zaworov.teamupapp.domain.team.VolleyballTeam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BeachVolleyballGame implements Game {
    private static final int NUMBERS_OF_TEAMS_IN_BEACH_VOLLEYBALL_GAME = 2;
    private static final int NUMBERS_OF_PLAYERS_IN_BEACH_VOLLEYBALL_GAME = 3;
    private static ArrayList<VolleyballTeam> volleyballTeams = new ArrayList<>();
    private static ArrayList<PlayerInterface> playerInterfaces = new ArrayList<>();
    private Long id;
    private LocalDateTime date;
    private TeamInterface[] winnerTeams;
    private ScoreInterface score;

    @Override
    public void addTeam(VolleyballTeam volleyballTeam) {
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }

    @Override
    public ScoreInterface getScore() {
        return null;
    }

    @Override
    public List<VolleyballTeam> getTeams() {
        return null;
    }

    @Override
    public List<VolleyballPlayer> getPlayers() {
        return null;
    }
}
