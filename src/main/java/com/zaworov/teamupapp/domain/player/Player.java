package com.zaworov.teamupapp.domain.player;

import java.util.List;

public abstract class Player implements PlayerInterface {

    @Override
    public List<PlayerInterface> getRoles() {
        return null;
    }

    public abstract List<PlayerInterface> getGamesWonTogether(PlayerInterface anotherPlayer);
}
