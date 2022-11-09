package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.team.TeamInterface;
import java.util.Date;
import java.util.List;

public class VolleyballGame implements Gameinterface {
    Long id;
    Date date;
    List<TeamInterface> teams;
    TeamInterface[] winnerTeams;
    ScoreInterface score;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public Date getDate() {
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
    public List<TeamInterface> getTeams() {
        return null;
    }

    @Override
    public List<PlayerInterface> getPlayers() {
        return null;
    }
}
