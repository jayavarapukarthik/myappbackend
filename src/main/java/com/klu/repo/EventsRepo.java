package com.klu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.model.Events;
@Repository
public interface EventsRepo extends JpaRepository<Events, Long> {

}
