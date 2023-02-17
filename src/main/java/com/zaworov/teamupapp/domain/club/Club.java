package com.zaworov.teamupapp.domain.club;

import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.player.PlayerInterface;

import java.time.LocalDateTime;
import java.util.List;

public class Club implements ClubInterface {
    String name;
    LocalDateTime establishDate;
    List<Game> games;
    List<PlayerInterface> playerInterfaces;

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

    public List<PlayerInterface> getPlayers() {
        return playerInterfaces;
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
