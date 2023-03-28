package com.zaworov.teamupapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaworov.teamupapp.builder.PlayerBuilder;
import com.zaworov.teamupapp.domain.player.PlayerInterface;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PlayerCtrlUnitTest {

    private static final String TEST_NAME = "John";
    private static final String TEST_SURNAME = "Derby";
    private static final VolleyballPlayer TEST_PLAYER = PlayerBuilder.aVolleyballPlayer(TEST_NAME, TEST_SURNAME);
    private static final long TEST_ID = 1L;
    private static final Long PLAYER_ID = 1L;
    private static final String PLAYER_URL = "/player/" + PLAYER_ID;
    private static final String SAVE_OR_UPDATE_PLAYER_URL = "/player";
    private static final String TEST_NAME_2 = "Bob";
    private static final String TEST_SURNAME_2 = "Okirk";
    private static final String ALL_PLAYERS_URL = "/players";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        TEST_PLAYER.setId(TEST_ID);
    }

    @Test
    void shouldReturnPlayer_whenGetPlayerById() throws Exception {
        when(playerService.getPlayerById(TEST_ID)).thenReturn(TEST_PLAYER);

        mockMvc.perform(MockMvcRequestBuilders.get(PLAYER_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(TEST_NAME))
                .andExpect(jsonPath("$.surname").value(TEST_SURNAME))
                .andReturn();

        then(playerService).should().getPlayerById(TEST_ID);
    }

    @Test
    void shouldDeletePlayer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(PLAYER_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        then(playerService).should(times(1)).delete(PLAYER_ID);
    }

    @Test
    void shouldSavePlayer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(SAVE_OR_UPDATE_PLAYER_URL)
                        .content(asJsonString(TEST_PLAYER))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

        then(playerService).should(times(1)).saveOrUpdate(any(VolleyballPlayer.class));
    }

    @Test
    void shouldUpdatePlayer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(SAVE_OR_UPDATE_PLAYER_URL)
                        .content(asJsonString(TEST_PLAYER))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(TEST_PLAYER.toString()));

        then(playerService).should(times(1)).saveOrUpdate(any(VolleyballPlayer.class));
    }


    @Test
    void shouldReturnAllPlayers_whenGetAllPlayers() throws Exception {
        List<PlayerInterface> listOfPlayers = Arrays.asList(
                PlayerBuilder.aVolleyballPlayer(TEST_NAME, TEST_SURNAME),
                PlayerBuilder.aVolleyballPlayer(TEST_NAME_2, TEST_SURNAME_2));
        when(playerService.getAllPlayers()).thenReturn(listOfPlayers);

        mockMvc.perform(MockMvcRequestBuilders.get(ALL_PLAYERS_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(TEST_NAME))
                .andExpect(jsonPath("$[0].surname").value(TEST_SURNAME))
                .andExpect(jsonPath("$[1].name").value(TEST_NAME_2))
                .andExpect(jsonPath("$[1].surname").value(TEST_SURNAME_2))
                .andReturn();
    }

    private String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}