package com.irshad.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.irshad.test.model.Registration;
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
		Registration registration = restTemplate.getForObject(getRootUrl() + "/reg/1", Registration.class);
		System.out.println(registration.getPlateNumber());
		assertNotNull(registration);
	}

	@Test
	public void testCreateRegistration() {
		Registration registration = new Registration();
		registration.setPlateNumber("admin");

		ResponseEntity<Registration> postResponse = restTemplate.postForEntity(getRootUrl() + "/reg", registration, Registration.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateRegistration() {
		int id = 1;
		Registration registration = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registration.class);
		registration.setPlateNumber("admin1");

		restTemplate.put(getRootUrl() + "/reg/" + id, registration);

		Registration updatedRegistration = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registration.class);
		assertNotNull(updatedRegistration);
	}

	@Test
	public void testDeleteRegistration() {
		int id = 2;
		Registration registration = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registration.class);
		assertNotNull(registration);

		restTemplate.delete(getRootUrl() + "/reg/" + id);

		try {
			registration = restTemplate.getForObject(getRootUrl() + "/reg/" + id, Registration.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
