CREATE TABLE rdv (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date_rdv DATETIME(6) NOT NULL,
    etat VARCHAR(255),
    patient_id INT NOT NULL,
    medecin_id INT NOT NULL,
    INDEX idx_rdv_patient_date (patient_id, date_rdv),
    INDEX idx_rdv_medecin_date (medecin_id, date_rdv)
) ENGINE=InnoDB;
