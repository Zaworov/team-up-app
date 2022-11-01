package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.game.Gameinterface;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PlayerInterface {
    Long getId();
    String getName();
    String getEmail();
    Integer getAge();
    Double getHeight();
    List<Game> getGamesWon();
    Map<Player, Integer> getGamesWonTogetherWithAllPlayersEverPlayed();
    List<Player> getGamesWonTogetherWithAllPlayersEverPlayed(Player anotherPlayer);
    List<Gameinterface> getGamesPlayedIn();
    List<PlayerInterface> getPlayerTypes();
    List<Action> getActions();
    Date getDateCreated();
    String getDescription();
}
