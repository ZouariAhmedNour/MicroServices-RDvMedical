package com.app.rdv.service;

import com.app.rdv.client.MedecinClient;
import com.app.rdv.client.PatientClient;
import com.app.rdv.dto.PatientDTO;
import com.app.rdv.entities.Medecin;
import com.app.rdv.entities.Patient;
import com.app.rdv.entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceRdv implements IServiceRdv {
    private final RdvRepository rdvRepository;
    private final PatientClient patientClient;
    private final MedecinClient medecinClient;

    @Override
    public Rdv ajoutRdv(Rdv rdv) {
        if (rdv.getPatientId() == null || rdv.getMedecinId() == null || rdv.getDateRdv() == null) {
            throw new IllegalArgumentException("patientId, medecinId et dateRdv sont obligatoires");
        }

        PatientDTO patientDTO = patientClient.findById(rdv.getPatientId());
        Medecin medecin = medecinClient.findById(rdv.getMedecinId());
        Optional<Rdv> rendezVousMedecin = rdvRepository
                .findByMedecinIdAndDateRdv(rdv.getMedecinId(), rdv.getDateRdv());
        Optional<Rdv> rendezVousPatient = rdvRepository
                .findByPatientIdAndDateRdv(rdv.getPatientId(), rdv.getDateRdv());

        if (rendezVousMedecin.isPresent() || rendezVousPatient.isPresent()) {
            return null;
        }
        rdv.setPatient(toPatient(patientDTO));
        rdv.setMedecin(medecin);
        return rdvRepository.save(rdv);
    }

    @Override
    public List<Rdv> getAllRdv() {
        return rdvRepository.findAll().stream().map(this::enrich).toList();
    }

    @Override
    public Optional<Rdv> getRdvById(Integer id) {
        return rdvRepository.findById(id).map(this::enrich);
    }

    private Rdv enrich(Rdv rdv) {
        rdv.setPatient(toPatient(patientClient.findById(rdv.getPatientId())));
        rdv.setMedecin(medecinClient.findById(rdv.getMedecinId()));
        return rdv;
    }

    private Patient toPatient(PatientDTO dto) {
        return new Patient(dto.getId(), dto.getNom(), dto.getPrenom(), dto.getAge(), dto.getTel(), dto.getMaladies());
    }
}