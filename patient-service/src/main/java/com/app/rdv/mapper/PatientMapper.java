package com.app.rdv.mapper;

import com.app.rdv.dto.PatientDTO;
import com.app.rdv.entities.Maladie;
import com.app.rdv.entities.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper {

    public Patient toEntity(PatientDTO dto){
        if(dto==null)
            return null;
        Patient patient = new Patient();
        patient.setId(dto.getId());
        patient.setPrenom(dto.getPrenom());
        patient.setNom(dto.getNom());
        patient.setAge(dto.getAge());
        patient.setTel(dto.getTel());
        return patient;
    }
    public PatientDTO toDTO(Patient patient){
        if(patient==null)
            return null;
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setPrenom(patient.getPrenom());
        patientDTO.setNom(patient.getNom());
        patientDTO.setAge(patient.getAge());
        patientDTO.setTel(patient.getTel());
        if(patient.getMaladies()!=null){
            List<String> maladies = new ArrayList<>();
            for(Maladie maladie:patient.getMaladies()){
                maladies.add(maladie.getNom());
            }
            patientDTO.setMaladies(maladies);
        }
        return patientDTO;
    }
    public List<PatientDTO> toDTOList(List<Patient> patients){
        if(patients==null)
            return null;
        List<PatientDTO> patientDTOs = new ArrayList<>();
        for(Patient patient:patients){
            patientDTOs.add(toDTO(patient));
        }
        return patientDTOs;
    }
}
