package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.team.Team;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

public interface GameInterface<P extends Player, T extends Team> {
    @Id
    Long getId();

    String getGroup();

    LocalDateTime getDate();

    String getName();

    String getDescription();

    ScoreInterface getScore();

    List<T> getTeams();

    List<P> getPlayers();
}
