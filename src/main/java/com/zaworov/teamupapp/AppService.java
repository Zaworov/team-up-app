package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.game.TeamCreationMode;
import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.player.PlayerTestDataHelper;

import java.util.ArrayList;

public class AppService {
    public static void Main(String[] args) {
        //Create game
        VolleyballGame volleyballGame = new VolleyballGame();
        //Create players
        ArrayList<Player> players = PlayerTestDataHelper.createFullSquadForVolleyballGame();
        //Assign players to the game
        volleyballGame.setPlayers(players);
        //"Create" and distribute players among teams
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        //

    }
}
