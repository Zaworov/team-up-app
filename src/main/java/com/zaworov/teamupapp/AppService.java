package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

public class AppService {
    private List<Player> playersList = new ArrayList();

    public void addNewPlayer(Player player) {
        playersList.add(player);
    }

    public List<Player> getPlayersList(){
        return playersList;
    };

}
