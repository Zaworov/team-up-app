package com.zaworov.teamupapp.repository;

import com.zaworov.teamupapp.domain.team.VolleyballTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolleyballTeamRepository extends CrudRepository<VolleyballTeam, Long> {
}
