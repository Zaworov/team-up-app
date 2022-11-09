package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.team.TeamInterface;

import java.util.Date;
import java.util.List;

public interface Gameinterface {
    Long getId();
    Date getDate();
    TeamInterface[] getWinnerTeams();
    ScoreInterface getScore();
    List<TeamInterface> getTeams();
    List<Player> getPlayers();
}
