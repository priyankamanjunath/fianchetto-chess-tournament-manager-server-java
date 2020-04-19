package com.example.fianchettochesstournamentmanagerserverjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.fianchettochesstournamentmanagerserverjava.models.Round;

public interface RoundRepository extends CrudRepository<Round, Integer> {

	
	@Query(value = "SELECT * FROM rounds WHERE tournament_id = :tournamentId", nativeQuery = true)
	public List<Round> findRoundsForTournament(@Param ("tournamentId") Integer tournamentId);

}
