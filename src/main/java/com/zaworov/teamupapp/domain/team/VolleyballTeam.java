package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.ScoreInterface;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "VOLLEYBALL_TEAM")
public class VolleyballTeam extends Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    //    @OneToMany(targetEntity = VolleyballPlayer.class, mappedBy = "team", fetch = FetchType.EAGER)
    @OneToMany()
    private List<VolleyballPlayer> players;

    @Column
    private int wins = 0;
    @Column
    private boolean isWinner = false;


    public VolleyballTeam() {
    }

    public VolleyballTeam(List<VolleyballPlayer> players) {
        this.players = players;
    }

    public void increaseWins() {
        this.wins++;
    }

    public void wins() {
        this.isWinner = true;
    }

    //    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    @Override
    public List<VolleyballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<VolleyballPlayer> players) {
        this.players = players;
    }

    @Override
    public ScoreInterface getScore() {
        return null;
    }

    @Override
    public Date getCreationDate() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
