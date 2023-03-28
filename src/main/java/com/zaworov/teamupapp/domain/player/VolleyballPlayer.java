package com.zaworov.teamupapp.domain.player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.team.VolleyballTeam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class VolleyballPlayer extends Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column
    private String name;

    @Column
    private String surname;
    @Column
    private String nickName;
    @Column
    private Double height;
    @Column
    private Double weight;
    @Column
    private Integer gamesWon;
    @Column
    private PlayerLevel level;

    @Column
    private String description;

    @Column
    private LocalDateTime dateCreated;

    @Column
    private Integer age;

    //    @JoinColumn(name = "team_fk")
    @ManyToOne()
    private VolleyballTeam team;

    @OneToMany(targetEntity = VolleyballGame.class)
    private List<VolleyballGame> playedGames = new ArrayList<>();
    @Column
    @NotBlank(message = "Email is mandatory")
    private String email;

    public VolleyballPlayer(String name,
                            String surname,
                            String nickName,
                            Double height,
                            Double weight,
                            Integer gamesWon,
                            PlayerLevel level,
                            String email,
                            String description,
                            LocalDateTime dateCreated,
                            Integer age) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.height = height;
        this.weight = weight;
        this.gamesWon = gamesWon;
        this.level = level;
        this.email = email;
        this.description = description;
        this.dateCreated = dateCreated;
        this.age = age;
    }

    public VolleyballPlayer(String name,
                            String surname,
                            String nickName,
                            Double height,
                            Double weight,
                            Integer gamesWon,
                            PlayerLevel level,
                            String email) {
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

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void scoresPoint() {
        //increases points of player
    }

    public void losesGame() {
        //saves game as lost
    }

    public void winsGame() {
        //saves game as won
    }

    public void addPlayedGame(VolleyballGame volleyballGame) {
        playedGames.add(volleyballGame);
    }
}

