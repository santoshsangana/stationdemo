package com.sangana.stationdemo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sangana.stationdemo.domain.Station;
import com.sangana.stationdemo.errorhandling.ExceptionHandler;
import com.sangana.stationdemo.service.StationDemoService;

/**
 * @author sksangana
 *
 */
@RestController
@RequestMapping("/station")
public class StationController {
	
	@Autowired
	StationDemoService service;
	
	@Autowired 
	ExceptionHandler handler;

	@GetMapping("/")
	public void BadMapping() throws Throwable {
		
		System.out.println("The path variable is ..." );

		handler.throwCustomException("Bad Request URI !!!");
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Station> findStationById(@PathVariable String id) throws Throwable {

		return service.getById(id);
	}

	@GetMapping("/name/{name}")
	public List<Station> findStationByName(@PathVariable String name) throws Exception {

		return service.getByName(name);
	}

	@GetMapping("/hdenabled/{isHdEnabled}")
	public List<Station> findStationByhdEnabled(@PathVariable String isHdEnabled) throws Exception {

		return service.getByhdEnabled(isHdEnabled);
	}

	@GetMapping("/all")
	public @ResponseBody List<Station> findAllStations() throws Exception {

		return (List<Station>) service.getAllStations();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStation(@PathVariable String id) throws Exception {
		
		service.deleteStation(id);
		return new ResponseEntity<Station>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/create")
	public ResponseEntity<Station> createStation(@RequestBody Station station) throws Exception {
		
		System.out.println("In the Request Create with the data : " + station);
		Station response = service.createStation(station);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/station/{id}").buildAndExpand(response.getStaionId()).toUri();
		return  ResponseEntity.created(location).build();
	}

}
