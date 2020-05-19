package com.irshad.test.controller;

import com.irshad.test.model.Registrations;
import com.irshad.test.repository.RegistrationsRepository;
import com.irshad.test.repository.InsurerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @Autowired
    private RegistrationsRepository registrationsRepository;

    @Autowired
    private InsurerRepository insurerRepository;


    @GetMapping("/reg")
    public List<Registrations> getAllRegistration() {

        return registrationsRepository.findAll();
    }

    @PostMapping("/reg")
    public Registrations createRegistration(@Valid @RequestBody Registrations registrations) {
        return registrationsRepository.save(registrations);
    }
}
