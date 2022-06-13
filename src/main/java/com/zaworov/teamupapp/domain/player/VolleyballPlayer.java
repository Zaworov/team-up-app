package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Gameinterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class VolleyballPlayer extends Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public List<Gameinterface> getGamesWon() {
        return null;
    }

    @Override
    public Map<PlayerInterface, Integer> getGamesWonTogether() {
        return null;
    }

    @Override
    public List<PlayerInterface> getGamesWonTogether(PlayerInterface anotherPlayer) {
        return null;
    }

    public List<PlayerInterface>getSetsWonTogether(PlayerInterface anotherPlayer){return null;}

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
