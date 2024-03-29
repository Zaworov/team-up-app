package com.zaworov.teamupapp.builder;

import com.zaworov.teamupapp.domain.player.*;

public class PlayerBuilder {
    private String name;

    private String surname;

    private String nickName;

    private Double height;

    private Double weight;

    private Integer gamesWon;

    private PlayerLevel level;

    private String email;

    public static VolleyballPlayer aVolleyballPlayer(String name, String surname) {
        PlayerInterface playerInterface = new PlayerBuilder().withName(name).withSurname(surname).build(PlayerType.VOLLEYBALL_PLAYER);
        return (VolleyballPlayer) playerInterface;
    }

    public PlayerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PlayerBuilder withNickname(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public PlayerBuilder withHeight(Double height) {
        this.height = height;
        return this;
    }

    public PlayerBuilder withWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public PlayerBuilder withGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
        return this;
    }

    public PlayerBuilder withLevel(PlayerLevel level) {
        this.level = level;
        return this;
    }

    public PlayerInterface build(PlayerType playerType) {
        switch (playerType) {
            case VOLLEYBALL_PLAYER:
                return new VolleyballPlayer(name, surname, nickName, height, weight, gamesWon, level, email);
            case FOOTBALL_PLAYER:
                return new FootballPlayer(name, surname, nickName, height, weight, gamesWon, level, email);
            default:
                return null;
        }
    }
}
