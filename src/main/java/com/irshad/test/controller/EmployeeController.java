package com.irshad.test.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.irshad.test.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irshad.test.exception.ResourceNotFoundException;
import com.irshad.test.repository.RegistrationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private RegistrationRepository registrationRepository;

	@GetMapping("/reg")
	public List<Registration> getAllEmployees() {
		return registrationRepository.findAll();
	}

	@GetMapping("/reg/{id}")
	public ResponseEntity<Registration> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Registration registration = registrationRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(registration);
	}

	@PostMapping("/reg")
	public Registration createEmployee(@Valid @RequestBody Registration registration) {
		return registrationRepository.save(registration);
	}

	@PutMapping("/reg/{id}")
	public ResponseEntity<Registration> updateEmployee(@PathVariable(value = "id") Long employeeId,
													   @Valid @RequestBody Registration registrationDetails) throws ResourceNotFoundException {
		Registration registration = registrationRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration not found for this id :: " + employeeId));

		registration.setPlateNumber(registrationDetails.getPlateNumber());
		final Registration updatedRegistration = registrationRepository.save(registration);
		return ResponseEntity.ok(updatedRegistration);
	}

	@DeleteMapping("/reg/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Registration registration = registrationRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration not found for this id :: " + employeeId));

		registrationRepository.delete(registration);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
