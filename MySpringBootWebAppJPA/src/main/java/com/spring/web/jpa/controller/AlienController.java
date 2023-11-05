package com.spring.web.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.jpa.dao.AlienRepo;
import com.spring.web.jpa.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("in home");
		return "home";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlient(@RequestParam int aId) {
		ModelAndView mv = new ModelAndView("showAlien");
		System.out.println("in get alien");
		Alien alien = repo.findById(aId).orElse(new Alien());
		
		System.out.println(repo.findByLanguage("Java"));
		System.out.println(repo.findByaIdGreaterThan(aId));		
		System.out.println(repo.findbyLanguageSorted("Java"));
		
		mv.addObject("alien", alien);
		return mv;
	}
	
	@RequestMapping("/addAlien")
	public String addAlient(Alien alien) {
		System.out.println("in add alien");
		repo.save(alien);
		return "home";
	}
	
	@RequestMapping("/updateAlien")
	public ModelAndView updateAlient(@RequestParam int aId, @RequestParam String language) {
		ModelAndView mv = new ModelAndView("showAlien");
		System.out.println("in update alien");
		Alien alien = repo.findById(aId).orElse(new Alien());
		if(alien.getaId() != 0) {
			repo.delete(alien);
			alien.setLanguage(language);
			repo.save(alien);
		}
		mv.addObject("alien", alien);
		return mv;
	}

}
