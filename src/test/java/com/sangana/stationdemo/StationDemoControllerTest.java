package com.sangana.stationdemo;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sangana.stationdemo.dao.StationDAO;
import com.sangana.stationdemo.domain.Station;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = StationController.class, secure = false)
//@ContextConfiguration(classes=StationdemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StationDemoControllerTest {
	

	@MockBean
	private StationDAO dao;
	
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

 
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
    @Test
	public void retrieveAll() throws Exception {

    	Station station1 = new Station("1", "PBC", true, "KXAN");
    	List<Station> list = new ArrayList<>();
    	list.add(station1);
		Mockito.when(dao.findAll()).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/station/name/pbc").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Printing the RESPONSE !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(result.getResponse().getContentAsString());
    }
}
 
