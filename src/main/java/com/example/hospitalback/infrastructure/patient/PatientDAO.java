package com.example.hospitalback.infrastructure.patient;

import com.example.hospitalback.domain.patient.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Integer> {
}
