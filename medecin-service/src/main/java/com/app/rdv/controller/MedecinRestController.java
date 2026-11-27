package com.app.rdv.controller;

import com.app.rdv.entities.Medecin;
import com.app.rdv.service.IServiceMedecin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecin/")
@AllArgsConstructor
public class MedecinRestController {

    IServiceMedecin iServiceMedecin;

    @GetMapping
    public List<Medecin> allMedecins(){
        return iServiceMedecin.getAllMedecins();
    }

    @PostMapping("add")
    public Medecin addMedecin(@RequestBody Medecin medecin){
        return iServiceMedecin.ajouterMedecin(medecin);
    }
}
