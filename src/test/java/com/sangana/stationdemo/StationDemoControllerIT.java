/**
 * 
 */
package com.sangana.stationdemo;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sangana.stationdemo.domain.Station;

/**
 * @author sksangana
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StationDemoControllerIT {
	
	@LocalServerPort
	int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
			}

	@Test
	public void test_getAllStation() throws Exception {
		
		String target = "/station/all";
		String url = createURL(target);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List<Station>> response = restTemplate.exchange(url, HttpMethod.GET, entity, 
				new ParameterizedTypeReference<List<Station>>() {});
		
		System.out.println("Printing RESPONSE !!! \n "+ response.getBody());
		Station station = new Station("1003", "ABC", true, "KVUE");
		assertTrue(response.getBody().contains(station));
	}

	private String createURL(String target) {
		String url = "http://localhost:" + port + target;
		return url;
	}
	
	@Test
	public void test_getByID() throws Exception {
		
		String target = "/station/1001";
		String url = createURL(target);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		
		String expected = "{staionId:\"1001\", name:NBC, hdEnabled:true, callSign:KXAN }";
		
		System.out.println("Printing RESPONSE !!! \n "+ response.getBody());
		System.out.println("Printing EXPECTED !!! \n "+ expected);
		
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void test_getByName() throws Exception {
		
		String target = "/station/name/NBC";
		String url = createURL(target);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List<Station>> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Station>>() {
		});
		
		String expected = "{staionId:\"1001\", name:NBC, hdEnabled:true, callSign:KXAN }";
		
		System.out.println("Printing RESPONSE !!! \n "+ response.getBody());
		System.out.println("Printing EXPECTED !!! \n "+ expected);
		
		Station station = new Station("1001", "NBC", true, "KXAN");
		assertTrue(response.getBody().contains(station));
	}


	@Test
	public void test_getByhdEnabled() throws Exception {
		
		String target = "/station/hdenabled/true";
		String url = createURL(target);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List<Station>> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Station>>() {
		});
		
		String expected = "{staionId:\"1001\", name:NBC, hdEnabled:true, callSign:KXAN }";
		
		System.out.println("Printing RESPONSE !!! \n "+ response.getBody());
		System.out.println("Printing EXPECTED !!! \n "+ expected);
		
		Station station = new Station("1001", "NBC", true, "KXAN");
		assertTrue(response.getBody().contains(station));
	}
	
	@Test
	public void test_addStation() throws Exception {
		
		String target = "/station/create";
		String url = createURL(target);
		
		Station body = new Station("1004", "PBC", false, "KBAN");
		
		HttpEntity<Station> entity = new HttpEntity<Station>(body, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		
		System.out.println("Printing HEADER ||| \n" + response.getHeaders().toString());
		System.out.println("Printing RESPONSE !!! \n "+ response.getBody());
		System.out.println("Printing ACTUAL !!! \n "+ actual);
		assertTrue(actual.contains("/station/1004"));
	}


}
