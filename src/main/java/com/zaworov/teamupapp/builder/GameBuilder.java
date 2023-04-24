package com.zaworov.teamupapp.builder;

import com.zaworov.teamupapp.domain.game.GameInterface;
import com.zaworov.teamupapp.domain.game.GameType;
import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.score.Score;
import com.zaworov.teamupapp.domain.team.Team;

import java.time.LocalDateTime;
import java.util.List;

public class GameBuilder {

    private String group = "TEST GROUP";
    private LocalDateTime date;
    private String description;
    private Score score;
    private List<Team> teams;
    private List<Player> players;

    public static VolleyballGame aVolleyballGame() {
        GameInterface gameInterface = new GameBuilder()
                .withDate(LocalDateTime.now())
                .withDescription("TEST DESCRIPTION")
                .build(GameType.VOLLEYBALL_GAME);
        return (VolleyballGame) gameInterface;
    }

    public GameBuilder withGroup(String group) {
        this.group = group;
        return this;
    }

    public GameBuilder withDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public GameBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public GameBuilder withScore(Score score) {
        this.score = score;
        return this;
    }

    public GameBuilder withTeams(List<Team> teams) {
        this.teams = teams;
        return this;
    }

    public GameBuilder withPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public GameInterface build(GameType playerType) {
        switch (playerType) {
            case VOLLEYBALL_GAME:
                return new VolleyballGame(group, date, description, score, teams, players);
            case FOOTBALL_GAME:
                return null;
//                return new FootballGame(name, surname, nickName, height, weight, gamesWon, level, email);
            default:
                return null;
        }
    }
}
