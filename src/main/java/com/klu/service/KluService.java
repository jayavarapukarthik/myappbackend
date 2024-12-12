package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Concerts;
import com.klu.model.Events;

import com.klu.model.Login;
import com.klu.model.Movies;
import com.klu.repo.ConcertsRepo;
import com.klu.repo.EventsRepo;
import com.klu.repo.KluRepo;
import com.klu.repo.LoginRepo;

@Service
public class KluService {
	@Autowired
	private KluRepo repo;
	@Autowired
	private EventsRepo eventsRepo;
	@Autowired
	private ConcertsRepo concertsRepo;
	
	@Autowired
	private LoginRepo loginRepo;
	
	public List<Movies> getAllMovies(){
		return repo.findAll();
	}
	public List<Events> getAllEvents(){
		return eventsRepo.findAll();
	}
	public List<Concerts> getAllConcerts(){
		return concertsRepo.findAll();
	}
	public Optional<Movies> getMoviesById(Long mid) {
	    return repo.findById(mid);
	  }
	public Optional<Events> getEventsById(Long mid) {
	    return eventsRepo.findById(mid);
	  }
	public Optional<Concerts> getConcertsById(Long mid) {
	    return concertsRepo.findById(mid);
	  }
	public Login loginByUsername(String username) {
		return loginRepo.findByUsername(username);
	}
}
