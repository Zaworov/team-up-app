package com.zaworov.teamupapp.domain.game;

import com.zaworov.teamupapp.domain.player.PlayerTestDataHelper;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.domain.team.VolleyballTeam;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class VolleyballGameUnitTest {
    public static ArrayList<VolleyballPlayer> TEST_PLAYERS;

    @BeforeEach
    void startup(){
        TEST_PLAYERS = PlayerTestDataHelper.createFullSquadForVolleyballGame();
    }

    @Ignore
    @Disabled
    void shouldRandomizeTeamsAndResultWithEqualTeams(){
        //given
        VolleyballGame volleyballGame = new VolleyballGame();
        volleyballGame.setPlayers(TEST_PLAYERS);
        int numberOfPlayers = volleyballGame.getPlayers().size();

        //when
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        VolleyballTeam volleyballTeamA = volleyballGame.getTeams().get(0);
        VolleyballTeam volleyballTeamB = volleyballGame.getTeams().get(1);
        int combinedTeamsSize = volleyballTeamA.getPlayers().size() + volleyballTeamB.getPlayers().size();

        //then
        assertThat(combinedTeamsSize, equalTo(numberOfPlayers));
    }

    @Test
    @Disabled
    void shouldRandomizeTeamsAndResultNotEvenTeams(){
        //given
        VolleyballGame volleyballGame = new VolleyballGame();
        List<VolleyballPlayer> playersWithOnePlayerLess = TEST_PLAYERS.subList(0, TEST_PLAYERS.size() - 1);
        volleyballGame.setPlayers(playersWithOnePlayerLess);
        int numberOfPlayers = volleyballGame.getPlayers().size();

        //when
        volleyballGame.createTeams(TeamCreationMode.FULLY_RANDOM);
        VolleyballTeam volleyballTeamA = volleyballGame.getTeams().get(0);
        VolleyballTeam volleyballTeamB = volleyballGame.getTeams().get(1);
        int combinedTeamsSize = volleyballTeamA.getPlayers().size() + volleyballTeamB.getPlayers().size();

        //then
        assertThat(combinedTeamsSize, equalTo(numberOfPlayers));
        assertNotEquals(volleyballTeamA.getPlayers().size(), volleyballTeamB.getPlayers().size());
    }
}