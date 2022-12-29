package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.score.VolleyballSetScore;
import com.zaworov.teamupapp.domain.team.VolleyballTeam;
import com.zaworov.teamupapp.domain.team.TeamInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VolleyballGame implements Game {
    private static final int NUMBERS_OF_TEAMS_IN_VOLLEYBALL_GAME = 2;
    private static final int NUMBERS_OF_PLAYERS_IN_VOLLEYBALL_GAME = 6;
    private List<VolleyballTeam> volleyballTeams = new ArrayList<>();

    private VolleyballTeam volleyballTeamA;
    private VolleyballTeam volleyballTeamB;
    private static List<VolleyballPlayer> PLAYERS = new ArrayList<>();

    private Long id;
    //    private Location location;
    private LocalDateTime date;
    private TeamInterface[] winnerTeams;
    private ScoreInterface score;

    public VolleyballGame() {
        this.date = LocalDateTime.now();
    }
    public Long getId() {
        return null;
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }

    @Override
    public TeamInterface[] getWinnerTeams() {
        return new TeamInterface[0];
    }

    @Override
    public ScoreInterface getScore() {
        return null;
    }

    @Override
    public List<VolleyballTeam> getTeams() {
        return volleyballTeams;
    }

    @Override
    public List<VolleyballPlayer> getPlayers() {
        return PLAYERS;
    }

    public void setWinnerTeams(TeamInterface[] winnerTeams) {
        this.winnerTeams = winnerTeams;
    }

    public void setFinalScore(ScoreInterface score) {
        this.score = score;
    }

    public void setTeams(List<VolleyballTeam> volleyballTeams) {
        this.volleyballTeams = volleyballTeams;
    }

    public void setPlayers(List<VolleyballPlayer> players) {
        VolleyballGame.PLAYERS = players;
    }

    @Override
    public void addTeam(VolleyballTeam volleyballTeam) { //todo it will be the same for each Game type (difference in number of players only), so it could go to abstract class Game
        if (volleyballTeams.size() == NUMBERS_OF_TEAMS_IN_VOLLEYBALL_GAME) {
            throw new RuntimeException("The new volleyball team cannot be added to the game, " +
                    "limit is {}" + NUMBERS_OF_TEAMS_IN_VOLLEYBALL_GAME); //TODO handle it
        }
        volleyballTeams.add(volleyballTeam);
    }

    public void createTeams(TeamCreationMode creationMode) {
        switch (creationMode) {
            case FULLY_RANDOM:
                assignPlayersToTeamsRandomly();
                break;
            case PLAY_WITH_FAVOURITE_COOPLAYERS:
                assignPlayersToTeamsByPlayerLevel();
                break;
            case PLAY_WITH_RAREST_COOPLAYERS:
                assignPlayersToTeamWithHandicup();
                break;
            default:
                throw new RuntimeException();
        }
    }

    private void assignPlayersToTeamsRandomly() {
        Collections.shuffle(PLAYERS);
        int availablePlayers = PLAYERS.size();
        int middlePoint = availablePlayers / 2;
        this.volleyballTeamA = new VolleyballTeam(PLAYERS.subList(0, middlePoint));
        this.volleyballTeamB = new VolleyballTeam(PLAYERS.subList(middlePoint, availablePlayers));
    }

    private void assignPlayersToTeamsByPlayerLevel() {
        //todo implement
    }

    private void assignPlayersToTeamWithHandicup() {
        //todo implement
    }

    public void updatePlayersWithFinishedGame() {
        for(VolleyballPlayer player : PLAYERS) {
            player.addPlayedGame(this);
        }
    }

    public void addSetScoreToTeams(VolleyballSetScore volleyballSetScore) {
       volleyballTeamA.addSetScore(volleyballSetScore);
        volleyballTeamB.addSetScore(volleyballSetScore);
    }
}
