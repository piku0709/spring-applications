package com.spring.web.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.web.jpa.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{
	
	public List<Alien> findByLanguage(String language);
	public List<Alien> findByaIdGreaterThan(int aId);
	
	@Query("from Alien where language=?1 order by aName desc")
	public List<Alien> findbyLanguageSorted(String language);

}
