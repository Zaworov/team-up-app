package com.zaworov.teamupapp;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.player.PlayerType;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class serviceTest {

    private static final String EXPECTED_PLAYER_NAME = "Piotr";
    private static final PlayerType EXPECTED_PLAYER_TYPE = PlayerType.VOLLEYBALL_PLAYER;

    AppService appService = new AppService();

    @Test
    void addVolleyballPlayerToEmptyPlayerList(){
        //given
        int expectedPlayerListSize = 1;
        Player volleyballPlayer = new VolleyballPlayer(); //TODO make a proper player with Builder

        //when
        appService.addNewPlayer(volleyballPlayer);

        //then
        assertThat(appService.getPlayersList().size()).isEqualTo(expectedPlayerListSize);
        //is instance of volleyball player
        //when().should()
    }

    @Test
    void createVolleyballGameWithAvailableListOfPlayer(){

    }

    @Test
    void distributeEvenNumberOfPlayersToTeamsWithinTheGame(){

    }

    @Test
    void distributeOddNumberOfPlayersToTeamsWithinTheGame(){

    }
}