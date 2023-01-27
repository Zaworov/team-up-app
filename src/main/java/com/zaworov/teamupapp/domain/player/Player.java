package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.VolleyballGame;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Player {
    List<Player> getGamesWonTogetherWithAllPlayersEverPlayed(Player anotherPlayer);

    void scoresPoint();

    void losesGame();

    void winsGame();

    Long getId();

    String getName();

    String getEmail();

    Integer getAge();

    Double getHeight();

    Integer getGamesWon();

    Map<Player, Integer> getGamesWonTogetherWithAllPlayersEverPlayed();

    List<VolleyballGame> getGamesPlayedIn();

    List<Player> getPlayerTypes();

    List<Action> getActions();

    Date getDateCreated();

    String getDescription();
}
