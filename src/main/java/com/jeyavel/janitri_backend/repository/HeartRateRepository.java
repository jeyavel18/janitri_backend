package com.jeyavel.janitri_backend.repository;

import com.jeyavel.janitri_backend.model.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
    List<HeartRate> findByPatientId(Long patientId);
}