package com.app.rdv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    private String specialite;
    private Integer prixConsultation;
}