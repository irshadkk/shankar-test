package com.irshad.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.irshad.test.model.Registrations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrationControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllRegistrations() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/reg",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetRegistrationById() {
		Registrations registrations = restTemplate.getForObject(getRootUrl() + "/reg/1", Registrations.class);
		System.out.println(registrations.getPaletNumber());
		assertNotNull(registrations);
	}

	@Test
	public void testCreateRegistration() {
		Registrations registrations = new Registrations();
		registrations.setPaletNumber("admin");

		ResponseEntity<Registrations> postResponse = restTemplate.postForEntity(getRootUrl() + "/reg", registrations, Registrations.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateRegistration() {
		int id = 1;
		Registrations registrations = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registrations.class);
		registrations.setPaletNumber("admin1");

		restTemplate.put(getRootUrl() + "/reg/" + id, registrations);

		Registrations updatedRegistrations = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registrations.class);
		assertNotNull(updatedRegistrations);
	}

	@Test
	public void testDeleteRegistration() {
		int id = 2;
		Registrations registrations = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registrations.class);
		assertNotNull(registrations);

		restTemplate.delete(getRootUrl() + "/reg/" + id);

		try {
			registrations = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registrations.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
