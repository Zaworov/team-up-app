package com.zaworov.teamupapp.repository;

import com.zaworov.teamupapp.domain.game.VolleyballGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolleyballGameRepository extends CrudRepository<VolleyballGame, Long> {
}

