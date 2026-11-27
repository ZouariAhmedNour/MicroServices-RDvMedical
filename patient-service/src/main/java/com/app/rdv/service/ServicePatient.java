package com.app.rdv.service;

import com.app.rdv.dto.PatientDTO;
import com.app.rdv.entities.Maladie;
import com.app.rdv.entities.Patient;
import com.app.rdv.mapper.PatientMapper;
import com.app.rdv.repository.MaladieRepository;
import com.app.rdv.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePatient implements IServicePatient{

    PatientRepository patientRepository;
    PatientMapper  patientMapper;
    MaladieRepository maladieRepository;
    @Override
    public PatientDTO ajouterPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO);
        patient = patientRepository.save(patient);
        return patientMapper.toDTO(patient);
    }

    /*@Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.toDTOList(patients);
    }*/

    @Override
    public Page<PatientDTO> getAllPatients(int page, int size) {

        Pageable pageable  =  PageRequest.of(page, size, Sort.by("id").ascending());
                Page<Patient> patients = patientRepository.findAll(pageable);
        return  patients.map(patientMapper::toDTO);
    }

    @Override
    public Optional<PatientDTO> getPatientById(int id) {
        Optional<Patient> patientOpt = patientRepository.findById(id);
        return patientOpt.map(patient -> patientMapper.toDTO(patient));
    }

    @Override
    public PatientDTO addMaladieToPatient(int patientId, int maladieId) {

        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        Optional<Maladie>  maladieOpt = maladieRepository.findById(maladieId);

        if(patientOpt.isEmpty() || maladieOpt.isEmpty())
            return null;

        Patient patient = patientOpt.get();
        Maladie maladie = maladieOpt.get();

        Optional<Patient> patient1 =  patientRepository.findByIdAndMaladiesId(patientId,maladieId);
        if(patient1.isEmpty()){
            patient.getMaladies().add(maladie);
            patient = patientRepository.save(patient);
        }
          return patientMapper.toDTO(patient);
    }
}
