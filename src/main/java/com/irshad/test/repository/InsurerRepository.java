package com.irshad.test.repository;

import com.irshad.test.model.Insurer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurerRepository extends JpaRepository<Insurer, Long> {
}