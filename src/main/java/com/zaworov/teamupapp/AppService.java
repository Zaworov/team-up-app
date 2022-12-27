package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.game.TeamCreationMode;
import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.player.PlayerTestDataHelper;
import com.zaworov.teamupapp.domain.score.VolleyballMatchScore;
import com.zaworov.teamupapp.domain.score.VolleyballSetScore;

import java.util.ArrayList;

public class AppService {
    public static void Main(String[] args) {
        //Create game
        VolleyballGame volleyballGame = new VolleyballGame();
        //Create players
        ArrayList<Player> players = PlayerTestDataHelper.createFullSquadForVolleyballGame();
        //Assign players to the game
        volleyballGame.setPlayers(players);
        //"Create" and distribute players among teams RANDOMLY
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        //Create match score
        VolleyballMatchScore matchScore = new VolleyballMatchScore();

        //1st set played
        VolleyballSetScore firstSetScore = new VolleyballSetScore(1, 10, 25);
        //Adding score to teams
        volleyballGame.addSetScoreToTeams(firstSetScore);
        //Updating matchScore
        matchScore.setScore(firstSetScore);

        //2nd set played
        VolleyballSetScore secondSetScore = new VolleyballSetScore(2, 10, 25);
        //Adding score to teams
        volleyballGame.addSetScoreToTeams(secondSetScore);
        //Updating matchScore
        matchScore.setScore(secondSetScore);

        //3rd set played
        VolleyballSetScore thirdSetScore = new VolleyballSetScore(3, 10, 25);
        //Adding score to teams
        volleyballGame.addSetScoreToTeams(thirdSetScore);
        //Updating matchScore
        matchScore.setScore(thirdSetScore);

        //FINISHED GAME SUMMARY
        //Assign score to finished game
        volleyballGame.setFinalScore(matchScore);
        //Assign game to players that played
        volleyballGame.updatePlayersWithFinishedGame();

    }
}
