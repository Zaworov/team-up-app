package com.zaworov.teamupapp.controller;

import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameCtrl {

    @Autowired
    GameService service;

    @GetMapping("/game/{gameid}")
    public Game getGame(@PathVariable("gameid") Long gameId) throws Exception {
        return service.getGameById(gameId);
    }

    @DeleteMapping("/game/{gameid}")
    public void deleteGame(@PathVariable("gameid") Long gameId) {
        service.delete(gameId);
    }

    @PostMapping("/game")
    public Long saveGame(@RequestBody Game game) {
        service.saveOrUpdate(game);
        return game.getId();
    }

    @PutMapping("/game")
    public Game update(@RequestBody Game game) {
        service.saveOrUpdate(game);
        return game;
    }

    @GetMapping("/games")
    public List<Game> getAllPlayers() {
        return service.getAllGames();
    }
}
