package com.app.rdv.service;

import com.app.rdv.entities.Rdv;

import java.util.List;
import java.util.Optional;

public interface IServiceRdv {
    Rdv ajoutRdv(Rdv rdv);
    List<Rdv> getAllRdv();
    Optional<Rdv> getRdvById(Integer id);
}