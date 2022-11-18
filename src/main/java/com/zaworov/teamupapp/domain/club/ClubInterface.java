package com.zaworov.teamupapp.domain.club;

import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.player.Player;

import java.util.Date;
import java.util.List;

public interface ClubInterface {
    String getName();
    Date getEstablishDate();
    List<Player> getPlayers();

    List<Game> getGames();

    List<Game> getGamesPlayer();
}
