package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.PlayerInterface;
import com.zaworov.teamupapp.domain.score.ScoreInterface;

import java.util.Date;
import java.util.List;

public interface TeamInterface {
    List<PlayerInterface> getPlayers();
    ScoreInterface getScore();
    Date getCreationDate();
    String getName();
}
