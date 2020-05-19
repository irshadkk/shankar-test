package com.irshad.test.repository;

import com.irshad.test.model.Registrations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationsRepository extends JpaRepository<Registrations, Long> {
 
}

 
