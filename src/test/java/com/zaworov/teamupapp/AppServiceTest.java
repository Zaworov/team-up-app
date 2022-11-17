package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.player.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;

class AppServiceTest {

    private static final String EXPECTED_PLAYER_NAME = "Jan";
    private static final String EXPECTED_PLAYER_SURNAME = "Kowalski";
    private static final String EXPECTED_PLAYER_NICKNAME = "Janek";
    private static final PlayerLevel EXPECTED_PLAYER_LEVEL = PlayerLevel.B;
    private static final PlayerType EXPECTED_PLAYER_TYPE = PlayerType.VOLLEYBALL_PLAYER;

    AppService appService = new AppService();

    PlayerBuilder playerBuilder = new PlayerBuilder();

    @Test
    void addVolleyballPlayerToEmptyPlayerList(){
        //given
        int expectedPlayerListSize = 1;
        Player volleyballPlayer = playerBuilder.withName("Jan").withSurname("Kowalski").withNickname("Janek").withLevel(PlayerLevel.B).build(PlayerType.VOLLEYBALL_PLAYER);

        //when
        appService.addNewPlayer(volleyballPlayer);

        //then
        assertThat(appService.getPlayersList(), hasSize(expectedPlayerListSize));
        assertThat(appService.getPlayersList().get(0), instanceOf(VolleyballPlayer.class));
    }

    @Test
    void createVolleyballClubAndStartAGame(){

    }

    @Test
    void addPlayersToStartedVolleyballGame(){

    }

    @Test
    void distributePlayersRandomlyAmongTeams(){

    }

    @Test
    void distributeOddNumberOfPlayersRandomlyAmongTeams(){

    }
}