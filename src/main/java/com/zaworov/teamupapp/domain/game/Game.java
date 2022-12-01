package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.team.Team;
import com.zaworov.teamupapp.domain.team.TeamInterface;

import java.time.LocalDateTime;
import java.util.List;

public interface Game {
    Long getId();
    LocalDateTime getDate();

    TeamInterface[] getWinnerTeams();
    ScoreInterface getScore();
    List<Team> getTeams();
    List<Player> getPlayers();
    void addTeam(Team team);
}
