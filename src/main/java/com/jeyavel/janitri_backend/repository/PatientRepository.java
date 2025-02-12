package com.jeyavel.janitri_backend.repository;

import com.jeyavel.janitri_backend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

