package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.game.TeamCreationMode;
import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.VolleyballSet;

import java.util.ArrayList;

public class AppService {
    public void playSet(VolleyballGame volleyballGame, VolleyballSet set) {
        volleyballGame.addSet(set);
        volleyballGame.addTeamWin(set);
        if (volleyballGame.checkIfFinished()) volleyballGame.finishTheGame();
    }

    public VolleyballGame createGameAndAssignPlayersRandomly(ArrayList<VolleyballPlayer> players) {
        VolleyballGame volleyballGame = new VolleyballGame();
        volleyballGame.setPlayers(players);
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        return volleyballGame;
    }
}
