package com.example.fianchettochesstournamentmanagerserverjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;

public interface MatchRepository extends CrudRepository<Match, Integer> {
	
	@Query(value = "SELECT * FROM matches WHERE round_id = :roundId", nativeQuery = true)
	public List<Match> findMatchesForRound(@Param ("roundId") Integer roundId);
	
	@Query(value = "SELECT * FROM matches WHERE player1_id = :userId OR player2_id = :userId",
			nativeQuery = true)
	public List<Match> findMatchesForUser(@Param ("userId") Integer userId);

	@Query(value = "SELECT m.* FROM matches AS m INNER JOIN rounds AS r ON m.round_id = r.id "
			+ "WHERE r.tournament_id = :tournamentId "
			+ "AND (m.player1_id = :userId OR m.player2_id = :userId)", nativeQuery = true)
	public List<Match> findUserMatchesForTournament(@Param ("userId") Integer userId,
			@Param ("tournamentId") Integer tournamentId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE matches SET result = :result WHERE id = :id", nativeQuery = true)
	public void updateMatchResult(@Param ("id") Integer id, @Param ("result") Integer result);

}
