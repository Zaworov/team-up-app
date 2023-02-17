package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.VolleyballGame;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PlayerInterface {
    List<PlayerInterface> getGamesWonTogetherWithAllPlayersEverPlayed(PlayerInterface anotherPlayerInterface);

    void scoresPoint();

    void losesGame();

    void winsGame();

    @Id
    Long getId();

    String getName();

    String getEmail();

    Integer getAge();

    Double getHeight();

    Integer getGamesWon();

    Map<PlayerInterface, Integer> getGamesWonTogetherWithAllPlayersEverPlayed();

    List<VolleyballGame> getGamesPlayedIn();

    List<PlayerInterface> getPlayerTypes();

    List<Action> getActions();

    Date getDateCreated();

    String getDescription();
}
