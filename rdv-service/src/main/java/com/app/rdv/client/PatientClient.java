package com.app.rdv.client;

import com.app.rdv.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service")
public interface PatientClient {
    @GetMapping("/api/patient/{id}")
    PatientDTO findById(@PathVariable("id") Integer id);
}