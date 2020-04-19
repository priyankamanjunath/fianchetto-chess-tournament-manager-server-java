package com.example.fianchettochesstournamentmanagerserverjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;

public interface MatchRepository extends CrudRepository<Match, Integer> {
	
	@Query(value = "SELECT * FROM matches WHERE round_id = :roundId", nativeQuery = true)
	public List<Match> findMatchesForRound(@Param ("roundId") Integer roundId);

}
