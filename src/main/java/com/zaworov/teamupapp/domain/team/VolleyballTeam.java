package com.zaworov.teamupapp.domain.team;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VOLLEYBALL_TEAM")
public class VolleyballTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToMany(mappedBy = "team")
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

    @Id
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

    public List<VolleyballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<VolleyballPlayer> players) {
        this.players = players;
    }
}
