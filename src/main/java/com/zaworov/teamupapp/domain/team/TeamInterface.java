package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.ScoreInterface;

import java.util.Date;
import java.util.List;

public interface TeamInterface<P extends Player> {
    List<P> getPlayers();

    ScoreInterface getScore();

    Date getCreationDate();

    String getName();
}
