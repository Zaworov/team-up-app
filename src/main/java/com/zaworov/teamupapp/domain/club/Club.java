package com.zaworov.teamupapp.domain.club;

import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.player.Player;

import java.time.LocalDateTime;
import java.util.List;

public class Club implements ClubInterface {
    String name;
    LocalDateTime establishDate;
    List<Game> games;
    List<Player> players;

    public Club(String name) {
        this.name = name;
        this.establishDate = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getEstablishDate() {
        return establishDate;
    }

    public List<Player> getPlayers() {
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
