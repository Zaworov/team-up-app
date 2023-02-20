package com.zaworov.teamupapp.domain.player;

import javax.persistence.Id;
import java.time.LocalDateTime;

public interface PlayerInterface {

    void scoresPoint();

    void losesGame();

    void winsGame();

    @Id
    Long getId();

    String getName();

    String getEmail();

    Integer getAge();

    Double getHeight();

    Integer getGamesWon();

    LocalDateTime getDateCreated();

    String getDescription();
}
