package com.spring.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.app.dao.AlienRepo;
import com.spring.web.app.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(path="/aliens", produces="application/xml")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@GetMapping(path="/aliens/{id}", produces="application/json")
	public Alien getAlienById(@PathVariable("id") int aId) {
		Alien alien = repo.findById(aId).orElse(new Alien());
		return alien;
	}
	
	@PostMapping(path="/aliens", consumes="application/json")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping(path="/aliens/{id}")
	public String deleteAlien(@PathVariable("id") int aId) {
		Alien alien = repo.getOne(aId);
		repo.delete(alien);
		return "deleted";
	}
	
	@PutMapping(path="/aliens", consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

}
