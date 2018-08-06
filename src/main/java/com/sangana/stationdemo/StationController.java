package com.sangana.stationdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.QueryMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangana.stationdemo.dao.StationDAO;
import com.sangana.stationdemo.domain.Station;


/**
 * @author sksangana
 *
 */
@RestController
public class StationController {
	
	@Autowired
	StationDAO stationDao;
	
@GetMapping("/{id}")	
public Optional<Station> findStationById(@PathVariable String id) {
	
	return stationDao.findById(id);
}

//@GetMapping("/{name}")	
@RequestMapping(method = RequestMethod.GET)
public @ResponseBody List<Station> findStationByName(@RequestParam(value="name") String name) {
	
	//model.put("tag1", val1);
	List<Station>  stations = stationDao.findAll();
	List<Station> reponseList = new ArrayList<>();
	
	for(Station station : stations) {
		if(station.getName().equalsIgnoreCase(name)) {
			reponseList.add(station);
		}
	}
	return reponseList;
}

@RequestMapping(value="/hdEnabled/{isHdEnabled}", method = RequestMethod.GET)
public @ResponseBody List<Station> findStationByhdEnabled(@PathVariable String isHdEnabled) {
	
	//model.put("tag1", val1);
	List<Station>  stations = stationDao.findAll();
	List<Station> reponseList = new ArrayList<>();
	
	for(Station station : stations) {
		if(station.isHdEnabled() && isHdEnabled.equalsIgnoreCase("true")) {
			reponseList.add(station);
		}
	}
	return reponseList;
}

@GetMapping("/all")	
public @ResponseBody List<Station> findAllStations(Map model) {
	
	//model.put("tag1", val1);
	
	return stationDao.findAll();
}

@DeleteMapping("/delete/{id}")
public void deleteStudent(@PathVariable String id) {
	stationDao.deleteById(id);
}

@PostMapping("/create")
public @ResponseBody Station createStation(@RequestBody Station station) {
	Station savedStation = stationDao.save(station);

//	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//			.buildAndExpand(savedStudent.getId()).toUri();

	return savedStation;

}

}
