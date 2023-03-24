package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.PlayerTestDataHelper;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.score.VolleyballSet;
import com.zaworov.teamupapp.domain.team.VolleyballTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VolleyballGameUnitTest {
    private static final String TOO_MANY_TEAM_MESSAGE = "The new volleyball team cannot be added to the game, limit is {}2";
    public static ArrayList<VolleyballPlayer> TEST_PLAYERS;

    @BeforeEach
    void startup() {
        TEST_PLAYERS = PlayerTestDataHelper.createFullSquadForVolleyballGame();
    }

    @Test
    void shouldRandomizeTeamsAndResultWithEqualTeams() {
        //given
        VolleyballGame volleyballGame = new VolleyballGame();
        volleyballGame.setPlayers(TEST_PLAYERS);
        int numberOfPlayers = volleyballGame.getPlayers().size();

        //when
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        VolleyballTeam volleyballTeamA = volleyballGame.getTeamA();
        VolleyballTeam volleyballTeamB = volleyballGame.getTeamB();
        int combinedTeamsSize = volleyballTeamA.getPlayers().size() + volleyballTeamB.getPlayers().size();

        //then
        assertEquals(combinedTeamsSize, numberOfPlayers);
    }

    @Test
    void shouldRandomizeTeamsAndResultNotEvenTeams() {
        //given
        VolleyballGame volleyballGame = new VolleyballGame();
        List<VolleyballPlayer> playersWithOnePlayerLess = TEST_PLAYERS.subList(0, TEST_PLAYERS.size() - 1);
        volleyballGame.setPlayers(playersWithOnePlayerLess);
        int numberOfPlayers = volleyballGame.getPlayers().size();

        //when
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        VolleyballTeam volleyballTeamA = volleyballGame.getTeamA();
        VolleyballTeam volleyballTeamB = volleyballGame.getTeamB();
        int teamASize = volleyballTeamA.getPlayers().size();
        int teamBSize = volleyballTeamB.getPlayers().size();
        int combinedTeamsSize = teamASize + teamBSize;

        //then
        assertEquals(combinedTeamsSize, numberOfPlayers);
        assertNotEquals(teamASize, teamBSize);
    }

    @Test
    void shouldThrowExceptionWhenThirdTeamBeingAdded() {
        VolleyballGame game = new VolleyballGame();
        game.addTeam(new VolleyballTeam());
        game.addTeam(new VolleyballTeam());
        Exception exception = assertThrows(RuntimeException.class, () -> game.addTeam(new VolleyballTeam()));
        assertEquals(TOO_MANY_TEAM_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldUpdatePlayersWithFinishedGame() {
        VolleyballGame game = new VolleyballGame();
        VolleyballPlayer playerA = new VolleyballPlayer();
        VolleyballPlayer playerB = new VolleyballPlayer();
        game.setPlayers(Arrays.asList(playerA, playerB));

        game.updatePlayersWithFinishedGame();

        assertEquals(1, game.getPlayers().get(0).getPlayedGames().size());
        assertEquals(1, game.getPlayers().get(1).getPlayedGames().size());
    }

    @Test
    void shouldAddWinToTeam() {
        VolleyballGame game = new VolleyballGame();

        game.addTeamWin(new VolleyballSet(1, 25, 20));

        assertEquals(1, game.getTeamA().getWins());
        assertEquals(0, game.getTeamB().getWins());
    }
}