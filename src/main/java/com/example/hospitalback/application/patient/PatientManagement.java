package com.example.hospitalback.application.patient;

import com.example.hospitalback.domain.patient.IJpaPatientRepository;
import com.example.hospitalback.domain.patient.Patient;
import com.example.hospitalback.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientManagement {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private IJpaPatientRepository iJpaPatientRepository;

    public PatientManagement(PatientRepository patientRepository, IJpaPatientRepository iJpaPatientRepository) {
        this.patientRepository = patientRepository;
        this.iJpaPatientRepository = iJpaPatientRepository;
    }

    public List<Patient> findPatients() {
        return  iJpaPatientRepository.findAll();
    }

    public Optional<Patient> findPatientById(int id) {
        Optional<Patient> patient = patientRepository.findPatientById(id);
        if(!patient.isPresent()){
            return null;
        }
        return patientRepository.findPatientById(id);
    }

    public  Patient addPatient(Patient patient){
        return patientRepository.addPatient(patient);
    }

    public Patient updatePatient(Patient patient){
        Optional<Patient> patient1 = patientRepository.findPatientById(patient.getId());
        if(patient1.isPresent()){
            return patientRepository.updatePatient(patient);
        }
        return  null;
    }

    public void deletePatient(int id){
        patientRepository.deletePatient(id);
    }

}
