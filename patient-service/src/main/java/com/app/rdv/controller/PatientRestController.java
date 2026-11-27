package com.app.rdv.controller;

import com.app.rdv.dto.PatientDTO;
import com.app.rdv.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/patient/")
@AllArgsConstructor
public class PatientRestController {
    IServicePatient iServicePatient;

    @GetMapping
    public Page<PatientDTO> getAllPatient(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size) {
        return iServicePatient.getAllPatients(page, size);
    }

    @PostMapping("add")
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO) {
        return iServicePatient.ajouterPatient(patientDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPatient(@PathVariable int id) {
        Optional<PatientDTO> patient = iServicePatient.getPatientById(id);
        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        }
        return new ResponseEntity<>("ce patient n'existe pas", HttpStatus.NOT_FOUND);
    }

    @PostMapping("addmaladie")
    public ResponseEntity<?> addmaladie(@RequestParam int idp, @RequestParam int idm) {
        PatientDTO patient = iServicePatient.addMaladieToPatient(idp, idm);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("cette maladie est déjà ajouté au patient", HttpStatus.CONFLICT);
    }
}