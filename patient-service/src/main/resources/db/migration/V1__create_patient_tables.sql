CREATE TABLE patient (
    id INT NOT NULL AUTO_INCREMENT,
    age INT,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    tel INT,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE maladie (
    id INT NOT NULL AUTO_INCREMENT,
    description VARCHAR(255),
    nom VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_maladie_nom UNIQUE (nom)
) ENGINE=InnoDB;

CREATE TABLE patient_maladies (
    patient_id INT NOT NULL,
    maladies_id INT NOT NULL,
    PRIMARY KEY (patient_id, maladies_id),
    INDEX ix_patient_maladies_maladie (maladies_id),
    CONSTRAINT fk_patient_maladies_patient
        FOREIGN KEY (patient_id) REFERENCES patient(id),
    CONSTRAINT fk_patient_maladies_maladie
        FOREIGN KEY (maladies_id) REFERENCES maladie(id)
) ENGINE=InnoDB;