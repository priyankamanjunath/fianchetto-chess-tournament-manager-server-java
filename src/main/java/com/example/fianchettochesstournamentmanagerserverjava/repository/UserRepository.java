package com.example.fianchettochesstournamentmanagerserverjava.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
