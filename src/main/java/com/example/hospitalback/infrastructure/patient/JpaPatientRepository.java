package com.example.hospitalback.infrastructure.patient;

import com.example.hospitalback.domain.patient.Patient;
import com.example.hospitalback.domain.patient.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaPatientRepository implements PatientRepository {

    private PatientDAO patientDAO;

    public JpaPatientRepository(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public Optional<Patient> findPatientById(int id) {
        return patientDAO.findById(id);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientDAO.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientDAO.save(patient);
    }

    @Override
    public void deletePatient(int id) {
        patientDAO.deleteById(id);
    }
}
