package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.player.PlayerTestDataHelper;
import com.zaworov.teamupapp.domain.team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class VolleyballGameUnitTest {
    public static ArrayList<Player> TEST_PLAYERS;

    @BeforeEach
    void startup(){
        TEST_PLAYERS = PlayerTestDataHelper.createFullSquadForVolleyballGame();
    }

    @Test
    void shouldRandomizeTeamsAndResultWithEqualTeams(){
        //given
        VolleyballGame volleyballGame = new VolleyballGame();
        volleyballGame.setPlayers(TEST_PLAYERS);
        int numberOfPlayers = volleyballGame.getPlayers().size();

        //when
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        Team teamA = volleyballGame.getTeams().get(0);
        Team teamB = volleyballGame.getTeams().get(1);
        int combinedTeamsSize = teamA.getPlayers().size() + teamB.getPlayers().size();

        //then
        assertThat(combinedTeamsSize, equalTo(numberOfPlayers));
    }

    @Test
    void shouldRandomizeTeamsAndResultNotEvenTeams(){
        //given
        VolleyballGame volleyballGame = new VolleyballGame();
        List<Player> playersWithOnePlayerLess = TEST_PLAYERS.subList(0, TEST_PLAYERS.size() - 1);
        volleyballGame.setPlayers(playersWithOnePlayerLess);
        int numberOfPlayers = volleyballGame.getPlayers().size();

        //when
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        Team teamA = volleyballGame.getTeams().get(0);
        Team teamB = volleyballGame.getTeams().get(1);
        int combinedTeamsSize = teamA.getPlayers().size() + teamB.getPlayers().size();

        //then
        assertThat(combinedTeamsSize, equalTo(numberOfPlayers));
        assertNotEquals(teamA.getPlayers().size(), teamB.getPlayers().size());
    }
}