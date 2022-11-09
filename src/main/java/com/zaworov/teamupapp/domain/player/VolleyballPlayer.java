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
public class VolleyballPlayer implements Player {

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

    public VolleyballPlayer(String name, String surname, String nickName, Double height, Double weight, Integer gamesWon, PlayerLevel level, String email) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.height = height;
        this.weight = weight;
        this.gamesWon = gamesWon;
        this.level = level;
        this.email = email;
    }

    public VolleyballPlayer() {
    }

    public List<Player> getVolleyballSetsWonTogether(Player anotherPlayer){return null;}

    public Long getId() {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getEmail() {
        return null;
    }

    public Integer getAge() {
        return null;
    }
    
    public Double getHeight() {
        return null;
    }

    public Integer getGamesWon() {
        return null;
    }

    public Map<Player, Integer> getGamesWonTogetherWithAllPlayersEverPlayed() {
        return null;
    }

    public List<Player> getGamesWonTogetherWithAllPlayersEverPlayed(Player anotherPlayer) {
        return null;
    }

    public List<Gameinterface> getGamesPlayedIn() {
        return null;
    }

    public List<Player> getPlayerTypes() {
        return null;
    }

    public List<Action> getActions() {
        return null;
    }

    public Date getDateCreated() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public void scoresPoint() {
    }

    public void losesGame() {
    }

    public void winsGame() {
    }
    
    public void scorePoint() {
    }
}
