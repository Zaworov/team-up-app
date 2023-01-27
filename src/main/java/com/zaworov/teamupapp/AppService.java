package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.game.TeamCreationMode;
import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.player.PlayerTestDataHelper;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.VolleyballSet;

import java.util.ArrayList;

public class AppService {
    public static void Main(String[] args) {
        ;
    }

    public void playGame() {
        //Create players
        ArrayList<VolleyballPlayer> players = PlayerTestDataHelper.createFullSquadForVolleyballGame();
        VolleyballGame volleyballGame = createGameAndAssignPlayersRandomly(players);

        playSet(volleyballGame, new VolleyballSet(1, 10, 25));
        playSet(volleyballGame, new VolleyballSet(2, 10, 25));
        playSet(volleyballGame, new VolleyballSet(3, 10, 25));

        volleyballGame.updatePlayersWithFinishedGame();
    }

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
