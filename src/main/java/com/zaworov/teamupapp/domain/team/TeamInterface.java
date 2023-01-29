package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.ScoreInterface;

import java.util.Date;
import java.util.List;

public interface TeamInterface {
    List<Player> getPlayers();

    ScoreInterface getScore();

    Date getCreationDate();

    String getName();
}
