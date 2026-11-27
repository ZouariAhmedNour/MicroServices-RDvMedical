package com.app.rdv.controller;


import com.app.rdv.entities.Maladie;
import com.app.rdv.service.IServiceMaladie;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maladie/")
public class MaladieRestController {
    IServiceMaladie iServiceMaladie;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Maladie maladie){
        Maladie maladie1 = iServiceMaladie.addMaladie(maladie);
        if(maladie1!=null)
            return new ResponseEntity<>(maladie1, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Cette maladie existe déjà dans la BD", HttpStatus.CONFLICT);
    }

    @GetMapping("all")
    public List<Maladie> getAll(){
        return iServiceMaladie.getAllMaladies();
    }

    @GetMapping("find")
    public Maladie getMaladie(@RequestParam String nom){
        return iServiceMaladie.getMaladieByNom(nom);
    }
}
