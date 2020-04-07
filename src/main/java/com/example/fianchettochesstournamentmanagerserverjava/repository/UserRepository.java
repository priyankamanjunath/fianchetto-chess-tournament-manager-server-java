package com.example.fianchettochesstournamentmanagerserverjava.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.fianchettochesstournamentmanagerserverjava.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE users SET name = :name, type = :type, number = :number, size = :size, text = :text, href = :href " 
			+ "WHERE id = :id", nativeQuery = true)
	public void updateWidget(@Param("id") Integer widgetId, @Param("name") String name, 
			@Param("type") String type, @Param("number") int number, @Param("size") int size, 
			@Param("text") String text, @Param("href") String href); 
	
}
