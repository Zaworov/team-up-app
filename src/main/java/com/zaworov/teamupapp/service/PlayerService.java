package com.zaworov.teamupapp.service;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.repository.VolleyballPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService<T extends Player> {

    @Autowired
    VolleyballPlayerRepository repository;

    public Player getPlayerById(Long id) throws Exception {
        Optional<VolleyballPlayer> player = repository.findById(id);
        if (player.isPresent()) return player.get();
        throw new Exception("Player not found by id: " + id);
    }

    public void saveOrUpdate(Player player) {
        repository.save((VolleyballPlayer) player);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        repository.findAll().forEach(players::add);
        return players;
    }
}
