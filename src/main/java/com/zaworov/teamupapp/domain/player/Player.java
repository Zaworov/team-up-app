package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.game.Gameinterface;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class Player implements PlayerInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;

    PlayerType type;
    protected Player(){

    }

    protected Player(PlayerType playerType){
        this.type = playerType;
    }

    @Override
    public List<PlayerInterface> getPlayerTypes() {
        return null;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public List<Game> getGamesWon() {
        return null;
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
    public List<Action> getActions() {
        return null;
    }

    @Override
    public Date getDateCreated() {
        return null;
    }

    @Override
    public Integer getAge() {
        return null;
    }

    @Override
    public Double getHeight() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }
}