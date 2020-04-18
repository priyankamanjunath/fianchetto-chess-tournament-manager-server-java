package com.example.fianchettochesstournamentmanagerserverjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;

public interface MatchRepository extends CrudRepository<Match, Integer> {

}
