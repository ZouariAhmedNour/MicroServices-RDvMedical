CREATE TABLE medecin (
    id INT NOT NULL AUTO_INCREMENT,
    adresse VARCHAR(255),
    nom VARCHAR(255),
    prenom VARCHAR(255),
    specialite VARCHAR(255),
    prix_consultation INT NOT NULL DEFAULT 50,
    PRIMARY KEY (id)
) ENGINE=InnoDB;