package com.klu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.model.Concerts;

public interface ConcertsRepo extends JpaRepository<Concerts, Long> {

}
