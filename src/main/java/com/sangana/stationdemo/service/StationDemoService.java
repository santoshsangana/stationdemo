package com.sangana.stationdemo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sangana.stationdemo.dao.StationDAO;
import com.sangana.stationdemo.domain.Station;
import com.sangana.stationdemo.errorhandling.ExceptionHandler;

@Service
@Repository
@Transactional
public class StationDemoService {
	
	@Autowired
	JdbcTemplate jdbctemp;
	
	@Autowired
	StationDAO dao;
	
	EntityManager entityMgr;
	
	@Autowired 
	ExceptionHandler handler;
	
	public Optional<Station> getById(String id) throws Exception {
		
		if(id == null) {
			handler.throwCustomException("Resource cannot be found by the Id : " + id);
		}
		
		Optional<Station> station = dao.findById(id);
		if(!station.isPresent()) {
			System.out.println("Executing getByID !!!");
			handler.throwCustomException("Resource cannot be found by the Id : " + id);
		}
		return station;
	}
	
	public List<Station> getByName(String name) throws Exception {
		
		
//		List<Station> stations = (List<Station>) stationDao.findAll();
//		List<Station> responseList = new ArrayList<>();
//
//		responseList = stations.stream().filter(station -> station.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
//		return responseList;

		List<Station> stations = dao.findByName(name);
		
		if(stations.isEmpty()) {
			handler.throwCustomException("Resource cannot be found by the name : " + name);
		}
		return stations;
	}
	
	public List<Station> getAllStations() throws Exception {

		List<Station> stations = (List<Station>) dao.findAll();
		
		if(stations.isEmpty()) {
			handler.throwCustomException("No resources found at the requested URI ");
		}
		return stations;
	}
	
	public List<Station> getByhdEnabled(String enabled) throws Exception {
		
		boolean filter;
		if (enabled.equalsIgnoreCase("true"))
			filter = true;
		else
			filter = false;

		List<Station> stations = dao.findByhdEnabled(filter);
		if(stations.isEmpty()) {
			handler.throwCustomException("Resource cannot be found which are hdenabled = " + enabled);
		}
		return stations;
	}
	
	public void deleteStation(String id) throws Exception{
		
			dao.deleteById(id);
	}
	
	public Station createStation(Station station) throws Exception {
		
		Station savedStation = null;
		try {
			savedStation = dao.save(station);
		} catch (Exception e) {
			handler.throwCustomException("Resource cannot be saved : " + station);
		}
		
		return savedStation;
	}
	
	public void saveAllStations(List<Station> stations) {
		
		dao.saveAll(stations);
	}
}
