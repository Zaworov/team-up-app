package com.zaworov.teamupapp.domain.player;

import com.zaworov.teamupapp.domain.action.Action;
import com.zaworov.teamupapp.domain.game.Gameinterface;
import com.zaworov.teamupapp.domain.user.UserInterface;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PlayerInterface extends UserInterface {
    Long getId();
    List<Gameinterface> getGamesWon();
    Map<PlayerInterface, Integer> getGamesWonTogether();
    List<Gameinterface> getGamesPlayedIn();
    List<PlayerInterface> getRoles();
    List<Action> getActions();
    Date getDateCreated();
    Integer getAge();
    Double getHeight();
    String getDescription();
    String getName();
    String getEmail();
}
