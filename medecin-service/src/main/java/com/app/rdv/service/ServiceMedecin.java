package com.app.rdv.service;

import com.app.rdv.entities.Medecin;
import com.app.rdv.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceMedecin implements IServiceMedecin {
    private final MedecinRepository medecinRepository;

    @Override
    public Medecin ajouterMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Optional<Medecin> getMedecinById(Integer id) {
        return medecinRepository.findById(id);
    }
}