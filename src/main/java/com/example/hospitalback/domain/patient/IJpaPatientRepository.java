package com.example.hospitalback.domain.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IJpaPatientRepository extends JpaRepository<Patient, Integer>, JpaSpecificationExecutor<Patient> {
}
