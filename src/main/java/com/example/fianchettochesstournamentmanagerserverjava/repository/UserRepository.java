package com.example.fianchettochesstournamentmanagerserverjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.fianchettochesstournamentmanagerserverjava.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT * FROM users WHERE email = :email AND password = :password", 
			nativeQuery = true)
	public User loginUser(@Param("email") String email, @Param("password") String password);
	
}
