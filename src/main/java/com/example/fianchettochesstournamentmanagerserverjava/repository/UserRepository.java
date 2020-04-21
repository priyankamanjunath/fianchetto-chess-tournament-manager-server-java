package com.example.fianchettochesstournamentmanagerserverjava.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.fianchettochesstournamentmanagerserverjava.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT * FROM users WHERE email = :email AND password = :password", 
			nativeQuery = true)
	public User loginUser(@Param("email") String email, @Param("password") String password);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM user_tournament WHERE player_id = :playerId AND tournament_id = :tournamentId", nativeQuery = true)
	public int deregister(@Param ("playerId") Integer userId, @Param ("tournamentId") Integer tournamentId);

	@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
	public User findByEmail(@Param ("email") String email);
}
