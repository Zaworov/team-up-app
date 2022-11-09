package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Gameinterface;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FootballPlayer implements Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String surname;

    private String nickName;

    private Double height;

    private Double weight;

    private Integer gamesWon;

    private PlayerLevel level;

    @NotBlank(message = "Email is mandatory")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    @Override
    public Map<Player, Integer> getGamesWonTogetherWithAllPlayersEverPlayed() {
        return null;
    }

    @Override
    public List<Player> getGamesWonTogetherWithAllPlayersEverPlayed(Player anotherPlayer) {
        return null;
    }

    @Override
    public List<Gameinterface> getGamesPlayedIn() {
        return null;
    }

    @Override
    public List<Player> getPlayerTypes() {
        return null;
    }

    @Override
    public List<Action> getActions() {
        return null;
    }

    @Override
    public Date getDateCreated() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void scoresPoint() {

    }

    @Override
    public void losesGame() {

    }

    @Override
    public void winsGame() {

    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }

    public PlayerLevel getLevel() {
        return level;
    }

    public void setLevel(PlayerLevel level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Integer getAge() {
        return null;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FootballPlayer(String name, String surname, String nickName, Double height, Double weight, Integer gamesWon, PlayerLevel level, String email) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.height = height;
        this.weight = weight;
        this.gamesWon = gamesWon;
        this.level = level;
        this.email = email;
    }
}
