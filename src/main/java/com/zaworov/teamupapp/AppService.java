package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

public class AppService {
    private List<Player> playersList = new ArrayList();

    //Create game
    VolleyballGame volleyballGame = new VolleyballGame();
    //Create players and assign them to the game
    //Distribute players among teams


    public void addNewPlayer(Player player) {
        playersList.add(player);
    }

    public List<Player> getPlayersList(){
        return playersList;
    };

}
