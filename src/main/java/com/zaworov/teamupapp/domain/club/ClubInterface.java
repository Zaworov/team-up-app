package com.zaworov.teamupapp.domain.club;

import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.player.Player;

import java.time.LocalDateTime;
import java.util.List;

public interface ClubInterface {
    String getName();

    LocalDateTime getEstablishDate();

    List<Player> getPlayers();

    List<Game> getGames();

    List<Game> getGamesPlayer();
}
