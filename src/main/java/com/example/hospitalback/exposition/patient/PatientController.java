package com.example.hospitalback.exposition.patient;

import com.example.hospitalback.application.patient.PatientManagement;
import com.example.hospitalback.domain.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientManagement patientManagement;

    @GetMapping(value = "/findAllPatients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllPatient()
        throws SQLException {

        try {
            List<Patient> patientList = patientManagement.findPatients();
            Map<String, Object> response = new HashMap<>();
            response.put("PatientList", patientList);
            response.put("totalItems", patientList.size());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/findPatientById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getOnePatient(@RequestParam int id)
       throws SQLException {

        try{
            Optional<Patient> patient = patientManagement.findPatientById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("patient", patient);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/savePatient", method = RequestMethod.POST)
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        try{
            Patient patient1 = patientManagement.addPatient(patient);
            return new ResponseEntity<>(patient1, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updatePatient", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody Patient patient){

        Optional<Patient> patient1 = patientManagement.findPatientById(patient.getId());
        if(patient1.isPresent()){
            return new ResponseEntity<>(patientManagement.updatePatient(patient), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/deletePatient", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam int id){

        try {
            Optional<Patient> patient = patientManagement.findPatientById(id);
            if(patient.isPresent()){
                patientManagement.deletePatient(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
