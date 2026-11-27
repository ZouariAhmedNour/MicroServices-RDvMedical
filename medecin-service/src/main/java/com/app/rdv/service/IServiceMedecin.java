package com.app.rdv.service;

import com.app.rdv.entities.Medecin;

import java.util.List;
import java.util.Optional;

public interface IServiceMedecin {
    Medecin ajouterMedecin(Medecin medecin);
    List<Medecin> getAllMedecins();
    Optional<Medecin> getMedecinById(Integer id);
}