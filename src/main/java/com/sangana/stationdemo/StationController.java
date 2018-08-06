package com.sangana.stationdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangana.stationdemo.dao.StationDAO;
import com.sangana.stationdemo.domain.Station;

/**
 * @author sksangana
 *
 */
@RestController
@RequestMapping("/station")
public class StationController {

	@Autowired
	StationDAO stationDao;

	@GetMapping("/{id}")
	public Optional<Station> findStationById(@PathVariable String id) {

		return stationDao.findById(id);
	}

	@GetMapping("/name/{name}")
	public List<Station> findStationByName(@PathVariable String name) {

		List<Station> stations = stationDao.findAll();
		List<Station> responseList = new ArrayList<>();

		responseList = stations.stream().filter(station -> station.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		return responseList;
	}

	@GetMapping("/hdenabled/{isHdEnabled}")
	public List<Station> findStationByhdEnabled(@PathVariable String isHdEnabled) {

		List<Station> stations = stationDao.findAll();
		List<Station> result = new ArrayList<>();

		boolean filter;
		if (isHdEnabled.equalsIgnoreCase("true"))
			filter = true;
		else
			filter = false;

		result = stations.stream().filter(x -> x.isHdEnabled() == filter).collect(Collectors.toList());

		return result;
	}

	@GetMapping("/all")
	public List<Station> findAllStations(Map model) {

		return stationDao.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable String id) {
		stationDao.deleteById(id);
	}

	@PostMapping("/create")
	public Station createStation(@RequestBody Station station) {
		Station savedStation = stationDao.save(station);

		return savedStation;

	}

}
