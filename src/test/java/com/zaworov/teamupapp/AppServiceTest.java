package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.domain.player.PlayerTestDataHelper;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.VolleyballSet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppServiceTest {

    AppService appService = new AppService();

    @Test
    void shouldCreateGameAndAssignPlayers() {
        ArrayList<VolleyballPlayer> players = PlayerTestDataHelper.createFullSquadForVolleyballGame();

        VolleyballGame game = appService.createGameAndAssignPlayersRandomly(players);

        assertEquals(players.size(), game.getPlayers().size());
        assertNotNull(game.getTeamA());
        assertNotNull(game.getTeamB());
        assertEquals(game.getTeamA().getPlayers().size(), game.getTeamB().getPlayers().size());
    }

    @Test
    void shouldPlaySingleSet() {
        VolleyballGame game = new VolleyballGame();
        VolleyballSet set = new VolleyballSet(1, 25, 10);

        appService.playSet(game, set);

        assertEquals(1, game.getSets().size());
        assertTrue(game.getSet(0).isFinished());
        assertFalse(game.isFinished());
    }

    @Test
    void shouldNotFinishGame() {
        VolleyballGame game = new VolleyballGame();
        VolleyballSet volleyballSet = new VolleyballSet(1, 20, 10);

        appService.playSet(game, volleyballSet);

        assertEquals(1, game.getSets().size());
        assertFalse(volleyballSet.isFinished());
        assertFalse(volleyballSet.isTieBreak());
        assertFalse(game.isFinished());
    }

    @Test
    void shouldPlayFiveSets() {
        VolleyballGame game = new VolleyballGame(); //todo move it to @Before

        appService.playSet(game, new VolleyballSet(1, 25, 10));
        appService.playSet(game, new VolleyballSet(2, 25, 22));
        appService.playSet(game, new VolleyballSet(3, 25, 27));
        appService.playSet(game, new VolleyballSet(4, 23, 25));
        appService.playSet(game, new VolleyballSet(5, 15, 11));

        assertEquals(5, game.getSets().size());
        assertTrue(game.isFinished());
        assertTrue(game.getSets().get(4).isTieBreak());
        assertTrue(game.getTeamA().isWinner());
    }
}