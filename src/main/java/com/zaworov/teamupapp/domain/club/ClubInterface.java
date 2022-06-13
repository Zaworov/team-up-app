package com.zaworov.teamupapp.domain.club;

import com.zaworov.teamupapp.domain.game.Gameinterface;
import com.zaworov.teamupapp.domain.player.PlayerInterface;

import java.util.Date;
import java.util.List;

public interface ClubInterface {
    String getName();
    Date getEstablishDate();
    List<PlayerInterface> getPlayers();

    List<Gameinterface> getGames();

    List<Gameinterface> getGamesPlayer();
}
