package com.zaworov.teamupapp.controller;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.player.PlayerInterface;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerCtrl {

    @Autowired
    PlayerService service;

    @GetMapping("/player/{playerid}")
    public PlayerInterface getPlayer(@PathVariable("playerid") Long playerId) throws Exception {
        return service.getPlayerById(playerId);
    }

    @DeleteMapping("/player/{playerid}")
    public void deletePlayer(@PathVariable("playerid") Long playerId) {
        service.delete(playerId);
    }

    @PostMapping("/player")
    public Long savePlayer(@RequestBody VolleyballPlayer player) {
        service.saveOrUpdate(player);
        return player.getId();
    }

    @PutMapping("/player")
    public Player update(@RequestBody VolleyballPlayer player) {
        service.saveOrUpdate(player);
        return player;
    }

    @GetMapping("/players")
    public List<PlayerInterface> getAllPlayers() {
        return service.getAllPlayers();
    }
}
