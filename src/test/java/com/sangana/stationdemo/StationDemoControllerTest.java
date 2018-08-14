package com.sangana.stationdemo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sangana.stationdemo.domain.Station;
import com.sangana.stationdemo.errorhandling.ExceptionHandler;
import com.sangana.stationdemo.service.StationDemoService;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = StationController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StationDemoControllerTest {
	

	@MockBean
	private StationDemoService service;
	@MockBean
	private ExceptionHandler errorHandler;
	
	@Autowired
    private MockMvc mockMvc;

 
    @Before
    public void setUp() throws Exception {
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
    @Test
	public void test_retrieveAll() throws Exception {

    	Station station1 = new Station("1", "PBC", true, "KXAN");
    	Station station2 = new Station("2", "BBC", true, "KBAN");
    	List<Station> list = new ArrayList<>();
    	list.add(station1);
    	list.add(station2);
		Mockito.when(service.getAllStations()).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/station/all").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Printing the EXPECTED !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(list);
		System.out.println("Printing the RESPONSE !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(result.getResponse().getContentAsString());
		
		ObjectMapper mapper = new ObjectMapper();

		// this uses a TypeReference to inform Jackson about the Lists's generic type
		List<Station> actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Station>>() {});

		assertEquals(list, actual);
		
    }
    
    @Test
	public void test_fundByName() throws Exception {

    	Station station1 = new Station("1", "PBC", true, "KXAN");
    	List<Station> list = new ArrayList<>();
    	list.add(station1);
		Mockito.when(service.getByName(Mockito.anyString())).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/station/name/PBC").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Printing the EXPECTED !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(list);
		System.out.println("Printing the RESPONSE !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(result.getResponse().getContentAsString());
		
		ObjectMapper mapper = new ObjectMapper();

		// this uses a TypeReference to inform Jackson about the Lists's generic type
		List<Station> actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Station>>() {});

		assertEquals(list, actual);
		
    }

    
    @Test
	public void test_findByID() throws Exception {

    	Optional<Station> station1 = Optional.of(new Station("1", "PBC", true, "KXAN"));
		Mockito.when(service.getById(Mockito.anyString())).thenReturn(station1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/station/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Printing the EXPECTED !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(station1);
		System.out.println("Printing the RESPONSE !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(result.getResponse().getContentAsString());
		
		ObjectMapper mapper = new ObjectMapper();

		// this uses a TypeReference to inform Jackson about the Lists's generic type
		Station actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Station>() {});

		assertEquals(station1.get(), actual);
    }
}
 
