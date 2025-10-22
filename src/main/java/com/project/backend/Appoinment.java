package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Future
    private LocalDateTime appointmentDate;

    private String status;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    // getters and setters
}
