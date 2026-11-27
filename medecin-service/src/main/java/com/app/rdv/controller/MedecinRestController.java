package com.app.rdv.controller;

import com.app.rdv.entities.Medecin;
import com.app.rdv.service.IServiceMedecin;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medecin/")
@AllArgsConstructor
public class MedecinRestController {
    private final IServiceMedecin serviceMedecin;

    @GetMapping
    public List<Medecin> allMedecins() {
        return serviceMedecin.getAllMedecins();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMedecin(@PathVariable Integer id) {
        Optional<Medecin> medecin = serviceMedecin.getMedecinById(id);
        if (medecin.isPresent()) {
            return ResponseEntity.ok(medecin.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ce médecin n'existe pas");
    }

    @PostMapping("add")
    public Medecin addMedecin(@RequestBody Medecin medecin) {
        return serviceMedecin.ajouterMedecin(medecin);
    }
}