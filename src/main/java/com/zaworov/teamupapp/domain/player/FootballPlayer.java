package com.zaworov.teamupapp.domain.player;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "football_players")
public class FootballPlayer extends Player {

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

    public FootballPlayer() {

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

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }

    @Override
    public LocalDateTime getDateCreated() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
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

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public LocalDateTime getBirthday() {
        return null;
    }
}
