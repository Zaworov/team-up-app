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
    private PlayerInterface getPlayer(@PathVariable("playerid") Long playerId) {
        return service.getPlayerById(playerId);
    }

    //creating a delete mapping that deletes a specified player
    @DeleteMapping("/player/{playerid}")
    private void deletePlayer(@PathVariable("playerid") Long playerId) {
        service.delete(playerId);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/player")
    private Long savePlayer(@RequestBody VolleyballPlayer player) {
        service.saveOrUpdate(player);
        return player.getId();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/player")
    private Player update(@RequestBody VolleyballPlayer player) {
        service.saveOrUpdate(player);
        return player;
    }

    @GetMapping("/book")
    private List<PlayerInterface> getAllPlayers() {
        return service.getAllPlayers();
    }
}
