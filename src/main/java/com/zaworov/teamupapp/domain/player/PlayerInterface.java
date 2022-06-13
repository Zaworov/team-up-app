package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Gameinterface;

import java.util.List;
import java.util.Map;

public interface PlayerInterface {
    Long getId();
    List<Gameinterface> getGamesWon();
    Map<PlayerInterface, Integer> getGamesWonTogether();
    List<Gameinterface> getGamesPlayedIn();
    List<PlayerInterface> getRoles();
    List<Action> getActions();
}
