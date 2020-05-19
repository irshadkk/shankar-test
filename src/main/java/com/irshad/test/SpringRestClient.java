package com.irshad.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringRestClient {

	private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
	}

}
