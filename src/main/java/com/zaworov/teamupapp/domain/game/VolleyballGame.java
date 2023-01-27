package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.ScoreInterface;
import com.zaworov.teamupapp.domain.score.VolleyballSet;
import com.zaworov.teamupapp.domain.team.TeamInterface;
import com.zaworov.teamupapp.domain.team.VolleyballTeam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VolleyballGame implements Game {
    private static final int NUMBERS_OF_TEAMS_IN_VOLLEYBALL_GAME = 2;
    private static final int NUMBERS_OF_PLAYERS_IN_VOLLEYBALL_GAME = 6;
    private static final int SETS_TO_WIN = 3;
    int teamAWins = 0;
    int teamBWins = 0;
    private List<VolleyballTeam> volleyballTeams = new ArrayList<>();
    private boolean isFinished = false;
    private VolleyballTeam teamA = new VolleyballTeam();
    private VolleyballTeam teamB = new VolleyballTeam();
    private List<VolleyballPlayer> players = new ArrayList<>();
    private List<VolleyballSet> sets = new ArrayList<>();
    private Long id;
    //    private Location location;
    private LocalDateTime date;
    private TeamInterface[] winnerTeams;

    public VolleyballGame() {
        this.date = LocalDateTime.now();
    }

    public void finishTheGame() {
        isFinished = true;
    }

    public boolean checkIfFinished() {
        if (sets.size() >= SETS_TO_WIN) {
            if (isAnyTeamAWinner()) {
                return true;
            }
        }
        return false;
    }

    public VolleyballSet getSet(int setNumber) {
        return sets.get(setNumber);
    }

    public void addSet(VolleyballSet setScore) {
        sets.add(setScore);
    }

    public void getScores() {
        //
    }

    @Override
    public void addTeam(VolleyballTeam volleyballTeam) { //todo it will be the same for each Game type (difference in number of players only), so it could go to abstract class Game
        if (volleyballTeams.size() == NUMBERS_OF_TEAMS_IN_VOLLEYBALL_GAME) {
            throw new RuntimeException("The new volleyball team cannot be added to the game, " + "limit is {}" + NUMBERS_OF_TEAMS_IN_VOLLEYBALL_GAME); //TODO handle it
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
        Collections.shuffle(players);
        int availablePlayers = players.size();
        int middlePoint = availablePlayers / 2;
        this.teamA = new VolleyballTeam(players.subList(0, middlePoint));
        this.teamB = new VolleyballTeam(players.subList(middlePoint, availablePlayers));

    }

    private void assignPlayersToTeamsByPlayerLevel() {
        //todo implement
    }

    private void assignPlayersToTeamWithHandicup() {
        //todo implement
    }

    public void updatePlayersWithFinishedGame() {
        for (VolleyballPlayer player : players) {
            player.addPlayedGame(this);
        }
    }

    public void addTeamWin(VolleyballSet volleyballSet) {
        if (volleyballSet.getTeamAScore() > volleyballSet.getTeamBScore()) {
            teamA.increaseWins();
            if (teamA.getWins() == 3) teamA.wins();
        } else {
            teamB.increaseWins();
            if (teamB.getWins() == 3) teamB.wins();
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    private boolean isAnyTeamAWinner() {
        return teamA.getWins() == SETS_TO_WIN || teamB.getWins() == SETS_TO_WIN;
    }

    public List<VolleyballTeam> getVolleyballTeams() {
        return volleyballTeams;
    }

    public VolleyballTeam getTeamA() {
        return teamA;
    }

    public VolleyballTeam getTeamB() {
        return teamB;
    }

    public List<VolleyballSet> getSets() {
        return sets;
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

    public void setWinnerTeams(TeamInterface[] winnerTeams) {
        this.winnerTeams = winnerTeams;
    }

    @Override
    public ScoreInterface getScore() {
        return null;
    }

    @Override
    public List<VolleyballTeam> getTeams() {
        return volleyballTeams;
    }

    public void setTeams(List<VolleyballTeam> volleyballTeams) {
        this.volleyballTeams = volleyballTeams;
    }

    @Override
    public List<VolleyballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<VolleyballPlayer> players) {
        this.players = players;
    }
}

