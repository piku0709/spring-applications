package com.spring.web.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.web.app.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

}
