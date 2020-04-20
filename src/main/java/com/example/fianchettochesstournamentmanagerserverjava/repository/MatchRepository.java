package com.example.fianchettochesstournamentmanagerserverjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;

public interface MatchRepository extends CrudRepository<Match, Integer> {
	
	@Query(value = "SELECT * FROM matches WHERE round_id = :roundId", nativeQuery = true)
	public List<Match> findMatchesForRound(@Param ("roundId") Integer roundId);
	
	@Query(value = "SELECT * FROM matches WHERE home_id = :userId OR away_id = :userId",
			nativeQuery = true)
	public List<Match> findMatchesForUser(@Param ("userId") Integer userId);

	@Query(value = "SELECT m.* FROM matches AS m INNER JOIN rounds AS r ON m.round_id = r.id "
			+ "WHERE r.tournament_id = :tournamentId "
			+ "AND (m.home_id = :userId OR m.away_id = :userId)", nativeQuery = true)
	public List<Match> findUserMatchesForTournament(@Param ("userId") Integer userId,
			@Param ("tournamentId") Integer tournamentId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE matches SET result = :result WHERE id = :id", nativeQuery = true)
	public void updateMatchResult(@Param ("id") Integer id, @Param ("result") Integer result);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE user_tournament SET points = points + :points "
			+ "WHERE player_id = :userId AND tournament_id = :tournamentId",nativeQuery = true)
	public void updatePoints(@Param ("userId") Integer integer
			, @Param ("tournamentId") Integer tournamentId, @Param("points") Double points);

	@Query (value = "SELECT points from user_tournament WHERE player_id = :playerId AND tournament_id = :tournamentId",
			nativeQuery = true)
	public Double getPoints(@Param ("playerId") Integer userId, @Param ("tournamentId") Integer tournamentId);

}
