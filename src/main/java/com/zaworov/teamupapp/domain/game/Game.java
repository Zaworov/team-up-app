package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.team.VolleyballTeam;

public abstract class Game implements GameInterface {

    public abstract void addTeam(VolleyballTeam volleyballTeam);
}
