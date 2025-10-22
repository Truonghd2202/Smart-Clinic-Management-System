# MySQL Database Design

## Doctor
- doctor_id INT (PK)
- name VARCHAR(100)
- specialty VARCHAR(100)
- phone VARCHAR(20)
- email VARCHAR(100)

## Patient
- patient_id INT (PK)
- name VARCHAR(100)
- dob DATE
- phone VARCHAR(20)
- email VARCHAR(100)

## Appointment
- appointment_id INT (PK)
- doctor_id INT (FK -> Doctor.doctor_id)
- patient_id INT (FK -> Patient.patient_id)
- appointment_date DATE
- appointment_time TIME
- status VARCHAR(20)

## Prescription
- prescription_id INT (PK)
- appointment_id INT (FK -> Appointment.appointment_id)
- details TEXT
