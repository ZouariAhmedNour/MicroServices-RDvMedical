package com.app.rdv.client;

import com.app.rdv.entities.Medecin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "medecin-service")
public interface MedecinClient {
    @GetMapping("/api/medecin/{id}")
    Medecin findById(@PathVariable("id") Integer id);
}