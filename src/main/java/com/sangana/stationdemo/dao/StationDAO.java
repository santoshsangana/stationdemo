package com.sangana.stationdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sangana.stationdemo.domain.Station;

@RepositoryRestResource
public interface StationDAO extends CrudRepository<Station, String> {
	
	List<Station> findAll();
	Optional<Station> findById(String id);
	List<Station> findStationByName(String name);
	@SuppressWarnings("unchecked")
	Station save(Station s); 
	void deleteById(String id);
	List<Station> findStationsByhdEnabled(String hdenabled);
}
