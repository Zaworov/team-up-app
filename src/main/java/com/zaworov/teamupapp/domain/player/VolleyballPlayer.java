package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Gameinterface;

import java.util.List;
import java.util.Map;

public class VolleyballPlayer extends Player {
    Long id;
    List<Gameinterface> games;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public List<Gameinterface> getGamesWon() {
        return null;
    }

    @Override
    public Map<PlayerInterface, Integer> getGamesWonTogether() {
        return null;
    }

    @Override
    public List<PlayerInterface> getGamesWonTogether(PlayerInterface anotherPlayer) {
        return null;
    }

    public List<PlayerInterface>getSetsWonTogether(PlayerInterface anotherPlayer){return null;}

    @Override
    public List<Gameinterface> getGamesPlayedIn() {
        return null;
    }

    @Override
    public List<Action> getActions() {
        return null;
    }
}
