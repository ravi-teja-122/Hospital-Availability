package com.spring.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	Optional<Hospital> findByName(String name);
}
