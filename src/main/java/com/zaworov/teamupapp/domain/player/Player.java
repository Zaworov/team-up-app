package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Gameinterface;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Player {
    Long getId();
    String getName();
    String getEmail();
    Integer getAge();
    Double getHeight();
    Integer getGamesWon();
    Map<Player, Integer> getGamesWonTogetherWithAllPlayersEverPlayed();
    List<Player> getGamesWonTogetherWithAllPlayersEverPlayed(Player anotherPlayer);
    List<Gameinterface> getGamesPlayedIn();
    List<Player> getPlayerTypes();
    List<Action> getActions();
    Date getDateCreated();
    String getDescription();
    void scoresPoint();
    void losesGame();
    void winsGame();
}
