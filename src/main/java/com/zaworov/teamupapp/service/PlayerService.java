package com.zaworov.teamupapp.service;

import com.zaworov.teamupapp.domain.player.Player;
import com.zaworov.teamupapp.domain.player.PlayerInterface;
import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import com.zaworov.teamupapp.repository.VolleyballPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    VolleyballPlayerRepository repository;

    //getting a specific record by using the method findById() of CrudRepository
    public PlayerInterface getPlayerById(Long id) {
        return repository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(VolleyballPlayer player) {
        repository.save(player);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //updating a record
    public void update(Player player, int id) {
        repository.save((VolleyballPlayer) player);
    }

    public List<PlayerInterface> getAllPlayers() {
        return null;
    }

    //getting all books record by using the method findaAll() of CrudRepository
    public List<PlayerInterface> getAllBooks() {
        List<PlayerInterface> playerInterfaces = new ArrayList<>();
        repository.findAll().forEach(player -> playerInterfaces.add(player));
        return playerInterfaces;
    }
}
