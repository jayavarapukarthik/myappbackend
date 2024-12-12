package com.klu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.model.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {
	Login findByUsername(String username);
}
