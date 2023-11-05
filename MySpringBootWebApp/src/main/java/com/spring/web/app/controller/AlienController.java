package com.spring.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.web.app.dao.AlienRepo;
import com.spring.web.app.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home";
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		return repo.findAll().toString();
	}
	
	@RequestMapping("/aliens/{id}")
	@ResponseBody
	public String getAlienById(@PathVariable("id") int aId) {
		Alien alien = repo.findById(aId).orElse(new Alien());
		return alien.toString();
	}

}
