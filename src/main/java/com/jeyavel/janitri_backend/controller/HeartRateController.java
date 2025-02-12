package com.jeyavel.janitri_backend.controller;

import com.jeyavel.janitri_backend.model.HeartRate;
import com.jeyavel.janitri_backend.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heartrate")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;

    @PostMapping("/record")
    public ResponseEntity<HeartRate> recordHeartRate(@RequestBody HeartRate heartRate) {
        return ResponseEntity.ok(heartRateService.recordHeartRate(heartRate));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HeartRate>> getHeartRatesByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(heartRateService.getHeartRatesByPatientId(patientId));
    }
}

