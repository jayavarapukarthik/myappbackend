package com.klu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Concerts;
import com.klu.model.Events;

import com.klu.model.Login;
import com.klu.model.Movies;
import com.klu.service.EmailService;
import com.klu.service.KluService;

@RestController
@CrossOrigin("*")
public class KluController {
		@Autowired
		private KluService service;
		
		@Autowired
	    private EmailService emailService;
		// New endpoint to send an email
	    @GetMapping("/send-email/{to}")
	    public String sendEmail(@PathVariable String to) {
	        String subject = "Order Confirmation";
	        String text = "Thank you for your order. Your payment has been received.";
	        
	        try {
	            emailService.sendEmail(to, subject, text);
	            return "Email sent successfully to " + to;
	        } catch (Exception e) {
	            return "Error sending email: " + e.getMessage();
	        }
	    }
	
		
		@GetMapping("/movies")
		public List<Movies> displayAllMovies(){
			return service.getAllMovies();
			
		}
		
		@PostMapping("/login")
		public Map<String, String> login(@RequestBody Login login) {
			// Fetch the Login object from the service
		    Login fetchedLogin = service.loginByUsername(login.getUsername());

		    // Prepare the response map
		    Map<String, String> response = new HashMap<>();
		    if (fetchedLogin != null && fetchedLogin.getPassword().equals(login.getPassword())) {
		        response.put("login", "success");
		    } else {
		        response.put("login", "fail");
		    }
		    return response;
		}
		@GetMapping("/events")
		public List<Events> displayAllEvents(){
			return service.getAllEvents();
			
		}
		@GetMapping("/concerts")
		public List<Concerts> displayAllConcerts(){
			return service.getAllConcerts();
			
		}
		
		@GetMapping("/movies/{mid}")
		public  Optional<Movies> getMoviesByID(@PathVariable Long mid)
	    {
	      return service.getMoviesById(mid);
	    }
		@GetMapping("/events/{mid}")
		public  Optional<Events> getEventsById(@PathVariable Long mid)
	    {
	      return service.getEventsById(mid);
	    }
		@GetMapping("/concerts/{mid}")
		public  Optional<Concerts> getConcertsById(@PathVariable Long mid)
	    {
	      return service.getConcertsById(mid);
	    }
		
}
