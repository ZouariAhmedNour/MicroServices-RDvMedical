package com.app.rdv.service;

import com.app.rdv.entities.Maladie;

import java.util.List;
public interface IServiceMaladie {
    public Maladie addMaladie(Maladie maladie);
    public List<Maladie> getAllMaladies();
    public Maladie getMaladieById(int id);
    public Maladie getMaladieByNom(String nom);

}
