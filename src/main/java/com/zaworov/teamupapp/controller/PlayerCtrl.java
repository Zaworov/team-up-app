package com.zaworov.teamupapp.controller;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerCtrl<T extends Player> {

    @Autowired
    PlayerService<T> service;

    @GetMapping("/player/{playerid}")
    public Player getPlayer(@PathVariable("playerid") Long playerId) throws Exception {
        return service.getPlayerById(playerId);
    }

    @DeleteMapping("/player/{playerid}")
    public void deletePlayer(@PathVariable("playerid") Long playerId) {
        service.delete(playerId);
    }

    @PostMapping("/player")
    public Long savePlayer(@RequestBody T player) {
        service.saveOrUpdate(player);
        return player.getId();
    }

    @PutMapping("/player")
    public Player update(@RequestBody Player player) {
        service.saveOrUpdate(player);
        return player;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return service.getAllPlayers();
    }
}
