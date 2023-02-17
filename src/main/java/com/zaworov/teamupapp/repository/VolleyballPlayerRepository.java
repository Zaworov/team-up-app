package com.zaworov.teamupapp.repository;

import com.zaworov.teamupapp.domain.player.VolleyballPlayer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolleyballPlayerRepository extends CrudRepository<VolleyballPlayer, Long> {
}
