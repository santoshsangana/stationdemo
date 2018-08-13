package com.sangana.stationdemo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sangana.stationdemo.domain.Station;
import com.sangana.stationdemo.service.StationDemoService;

@SpringBootApplication
@EnableJpaRepositories
public class StationdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationdemoApplication.class, args);
	}
	
	@Autowired
	StationDemoService service;

	@PostConstruct
	public void init() {
		
		List<Station> list = new ArrayList<>();
				
		list.add(new Station("1001", "NBC", true, "KXAN"));
		list.add(new Station("1002", "FOX", false, "KTBC"));
		list.add(new Station("1003", "ABC", true, "KVUE"));
		
		service.saveAllStations(list);
	}
	
}
