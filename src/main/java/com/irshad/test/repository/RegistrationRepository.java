package com.irshad.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irshad.test.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
