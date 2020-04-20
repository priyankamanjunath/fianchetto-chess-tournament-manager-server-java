package com.example.fianchettochesstournamentmanagerserverjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.fianchettochesstournamentmanagerserverjava.models.UserTournament;

public interface UserTournamentRepository extends CrudRepository<UserTournament, Integer> {

}
