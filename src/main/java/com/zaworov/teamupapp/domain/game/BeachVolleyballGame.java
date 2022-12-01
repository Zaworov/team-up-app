package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.team.Team;
import com.zaworov.teamupapp.domain.team.TeamInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BeachVolleyballGame implements Game{
    private static final int NUMBERS_OF_TEAMS_IN_BEACH_VOLLEYBALL_GAME = 2;
    private static final int NUMBERS_OF_PLAYERS_IN_BEACH_VOLLEYBALL_GAME = 3;

    private Long id;
    private LocalDateTime date;
    private TeamInterface[] winnerTeams;
    private ScoreInterface score;
    private static ArrayList<Team> teams = new ArrayList<>();
    private static ArrayList<Player> players = new ArrayList<>();
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }

    @Override
    public TeamInterface[] getWinnerTeams() {
        return new TeamInterface[0];
    }

    @Override
    public ScoreInterface getScore() {
        return null;
    }

    @Override
    public List<Team> getTeams() {
        return null;
    }

    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public void addTeam(Team team) {
    }
}
