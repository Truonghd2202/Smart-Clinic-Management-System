package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public ResponseEntity<Map<String, String>> loginDoctor(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        Map<String, String> response = new HashMap<>();

        if (doctor != null && password.equals("123456")) { // tạm giả password
            response.put("token", UUID.randomUUID().toString());
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid credentials");
            return ResponseEntity.status(401).body(response);
        }
    }

    public ResponseEntity<?> getDoctorAvailability(Long doctorId, String date, String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid token");
        }
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        return doctor.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(404).body("Doctor not found"));
    }
}
