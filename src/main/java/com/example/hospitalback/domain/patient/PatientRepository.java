package com.example.hospitalback.domain.patient;

import java.util.List;
import java.util.Optional;


public interface PatientRepository {

    Optional<Patient> findPatientById(int id);

    Patient addPatient(Patient patient);

    Patient updatePatient(Patient patient);

    void deletePatient(int id);

}
