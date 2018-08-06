package com.sangana.stationdemo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sangana.stationdemo.dao.StationDAO;
import com.sangana.stationdemo.domain.Station;

@SpringBootApplication
@EnableJpaRepositories
public class StationdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationdemoApplication.class, args);
	}
	
	
	
//	@PostConstruct
//	public void init() {
//		
//		List<Station> list = new ArrayList<>();
//		
//		
//		list.add(new Station("1234", "Hyd", true, "NP3DR"));
//		list.add(new Station("2345", "Madras", false, "GP3LE"));
//		
//		
//		stationDao.saveAll(list);
//		
//	}
	
	@Autowired
	StationDAO stationDao;
}
