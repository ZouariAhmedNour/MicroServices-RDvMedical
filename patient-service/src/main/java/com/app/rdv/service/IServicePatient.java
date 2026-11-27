package com.app.rdv.service;

import com.app.rdv.dto.PatientDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IServicePatient {
    PatientDTO ajouterPatient(PatientDTO patientDTO);
    //List<PatientDTO> getAllPatients();
    Page<PatientDTO> getAllPatients(int  page, int size);
    Optional<PatientDTO> getPatientById(int id);
    PatientDTO addMaladieToPatient(int patientId, int maladieId);
}
