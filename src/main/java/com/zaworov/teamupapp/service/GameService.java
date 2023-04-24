package com.zaworov.teamupapp.service;

import com.zaworov.teamupapp.domain.game.Game;
import com.zaworov.teamupapp.domain.game.VolleyballGame;
import com.zaworov.teamupapp.repository.VolleyballGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    VolleyballGameRepository repository;

    public Game getGameById(Long gameId) throws Exception {
        Optional<VolleyballGame> game = repository.findById(gameId);
        if (game.isPresent()) return game.get();
        throw new Exception("Player not found by id: " + gameId);
    }

    public void delete(Long gameId) {
        repository.deleteById(gameId);
    }

    public void saveOrUpdate(Game game) {
        repository.save((VolleyballGame) game);
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        repository.findAll().forEach(games::add);
        return games;
    }
}
