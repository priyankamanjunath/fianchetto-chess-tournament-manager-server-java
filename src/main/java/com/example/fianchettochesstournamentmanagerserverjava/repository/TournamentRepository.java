package com.example.fianchettochesstournamentmanagerserverjava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;

public interface TournamentRepository extends CrudRepository<Tournament, Integer> {

}
