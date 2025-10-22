package com.project.back_end.controllers;

import com.project.back_end.services.DoctorService;
import com.project.back_end.services.TokenService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private final DoctorService doctorService;
    private final TokenService tokenService;

    public DoctorController(DoctorService doctorService, TokenService tokenService) {
        this.doctorService = doctorService;
        this.tokenService = tokenService;
    }

    @GetMapping("/doctor/{user}/availability")
    public ResponseEntity<?> getDoctorAvailability(@PathVariable String user, @RequestHeader("Authorization") String token) {
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        return ResponseEntity.ok(doctorService.getAvailability(user));
    }
}
