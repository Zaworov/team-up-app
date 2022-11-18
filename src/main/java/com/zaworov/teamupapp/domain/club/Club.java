package com.zaworov.teamupapp.domain.club;

import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.player.Player;

import java.util.Date;
import java.util.List;

public class Club implements ClubInterface {
    String name;
    LocalDateTime establishDate;
    List<Game> games;
    List<Player> players;

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
    public List<Game> getGames() {
        return games;
    }

    @Override
    public List<Game> getGamesPlayer() {
        return null;
    }
}
