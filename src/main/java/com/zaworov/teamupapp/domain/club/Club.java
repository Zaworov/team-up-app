package com.zaworov.teamupapp.domain.club;

import com.zaworov.teamupapp.domain.game.Gameinterface;
import com.zaworov.teamupapp.domain.player.PlayerInterface;

import java.util.Date;
import java.util.List;

public class Club implements ClubInterface {
    String name;
    Date establishDate;
    List<Gameinterface> games;
    List<PlayerInterface> players;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getEstablishDate() {
        return establishDate;
    }

    @Override
    public List<PlayerInterface> getPlayers() {
        return players;
    }

    @Override
    public List<Gameinterface> getGames() {
        return games;
    }

    @Override
    public List<Gameinterface> getGamesPlayer() {
        return null;
    }
}
