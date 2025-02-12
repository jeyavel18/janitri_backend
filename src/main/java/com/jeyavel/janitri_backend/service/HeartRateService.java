package com.jeyavel.janitri_backend.service;

import com.jeyavel.janitri_backend.model.HeartRate;
import com.jeyavel.janitri_backend.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HeartRateService {
    @Autowired
    private HeartRateRepository heartRateRepository;

    public HeartRate recordHeartRate(HeartRate heartRate) {
        heartRate.setTimestamp(LocalDateTime.now());
        return heartRateRepository.save(heartRate);
    }

    public List<HeartRate> getHeartRatesByPatientId(Long patientId) {
        return heartRateRepository.findByPatientId(patientId);
    }
}
