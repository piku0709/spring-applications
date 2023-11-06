package com.spring.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.web.app.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

}
