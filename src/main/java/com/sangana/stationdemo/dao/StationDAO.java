package com.sangana.stationdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sangana.stationdemo.domain.Station;

@RepositoryRestResource(path="stations", collectionResourceRel="stations")
public interface StationDAO extends CrudRepository<Station, String> {
	
	List<Station> findByName(String name);
	List<Station> findByhdEnabled(boolean hdenabled);
}
