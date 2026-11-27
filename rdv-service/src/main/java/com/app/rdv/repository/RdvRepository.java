package com.app.rdv.repository;

import com.app.rdv.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {
    Optional<Rdv> findByMedecinIdAndDateRdv(Integer medecinId, LocalDateTime dateRdv);
    Optional<Rdv> findByPatientIdAndDateRdv(Integer patientId, LocalDateTime dateRdv);
}
