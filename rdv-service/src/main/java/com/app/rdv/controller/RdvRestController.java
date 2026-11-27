package com.app.rdv.controller;

import com.app.rdv.entities.Rdv;
import com.app.rdv.service.IServiceRdv;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rdv")
@RequiredArgsConstructor
public class RdvRestController {
    private final IServiceRdv serviceRdv;

    @GetMapping
    public List<Rdv> findAll() {
        return serviceRdv.getAllRdv();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return serviceRdv.getRdvById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Aucun rendez-vous trouvé avec l'identifiant " + id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRdv(@RequestBody Rdv rdv) {
        Rdv saved = serviceRdv.ajoutRdv(rdv);
        if (saved == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Le rendez-vous chevauche un autre rendez-vous.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}