package com.sangana.stationdemo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sangana.stationdemo.dao.StationDAO;
import com.sangana.stationdemo.domain.Station;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class StationdemoApplicationTests {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private StationDAO stationDao;
    
 	@Test
	public void contextLoads() {
		entityManager.clear();
	}
	
    @Test
    public void test_FindAll() {
    	
		Station station1 = new Station("1", "PBC", true, "KXAN");
		entityManager.persist(station1);
		Station station2 = new Station("2", "ESPN", true, "KTBC");
		entityManager.persist(station2);
		
		List<Station> foundList = stationDao.findAll();
		assert(foundList.size() == 5);
		
    }

    @Test
    public void test_FindById() {
    	
		Station station = new Station("3", "NBC", true, "KXAN");
		entityManager.persist(station);
		
		Optional<Station> found = stationDao.findById("3");
		assertEquals("NBC", found.get().getName());
		
    }

    @Test
    public void test_FindByStationName() {
    	
		Station station = new Station("4", "TNT", true, "KTBC");
		entityManager.persist(station);
		List<Station> foundlist = stationDao.findStationByName("TNT");
		assertEquals(station, foundlist.stream().filter(found -> "TNT".equalsIgnoreCase(found.getName())).findAny().orElse(null) );
		
    }

    @Test
    public void test_AddStation() {
    	
		Station station = new Station("6", "TBS", false, "KTBC");
		entityManager.persist(station);
		Station response = stationDao.save(station);
		
		assertEquals("6", response.getStaionId());
		
    }

}
