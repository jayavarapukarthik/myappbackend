package com.klu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.model.Movies;
@Repository
public interface KluRepo extends JpaRepository<Movies, Long> {

}
