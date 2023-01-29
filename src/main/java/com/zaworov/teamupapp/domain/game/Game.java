package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.team.TeamInterface;
import com.zaworov.teamupapp.domain.team.VolleyballTeam;

import java.time.LocalDateTime;
import java.util.List;

public interface Game {
    void addTeam(VolleyballTeam volleyballTeam);

    Long getId();

    LocalDateTime getDate();

    TeamInterface[] getWinnerTeams();

    ScoreInterface getScore();

    List<VolleyballTeam> getTeams();

    List<VolleyballPlayer> getPlayers();
}
