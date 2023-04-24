package com.zaworov.teamupapp.domain.player;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PlayerDeserializer.class)
public abstract class Player implements PlayerInterface {
}
