package com.zaworov.teamupapp.domain.game;

public enum TeamCreationMode {
/**
 * FULLY RANDOM - fully random
 * PLAY_WITH_FAVOURITE_COOPLAYERS - tries to assign players that play with each other most often
 * PLAY_WITH_RAREST_COOPLAYERS - tries to assign players that play with each other rarest
 */

    FULLY_RANDOM,
    PLAY_WITH_FAVOURITE_COOPLAYERS,
    PLAY_WITH_RAREST_COOPLAYERS,
}
