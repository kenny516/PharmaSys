CREATE DATABASE pharma_sys;
\c pharma_sys;

CREATE TABLE Laboratoire
(
    id        SERIAL,
    nom       VARCHAR(50),
    telephone VARCHAR(50),
    adresse   VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Maladie
(
    id          SERIAL,
    nom         VARCHAR(50),
    description TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE Vente
(
    id            SERIAL,
    date_vente    TIMESTAMP,
    montant_total double precision,
    PRIMARY KEY (id)
);

CREATE TABLE Public_cible
(
    id        SERIAL,
    categorie VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Type_mvt_stock
(
    id          SERIAL,
    nom         VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE (nom)
);

CREATE TABLE Role
(
    id          SERIAL,
    nom         VARCHAR(50),
    description VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE (nom)
);

CREATE TABLE Medicament
(
    id             SERIAL,
    nom            VARCHAR(50),
    description    TEXT,
    prix           double precision,
    id_laboratoire INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (id_laboratoire) REFERENCES Laboratoire (id)
);

CREATE TABLE Fournisseur
(
    id      SERIAL,
    nom     VARCHAR(50),
    contact VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Vente_detail
(
    id              SERIAL,
    quantite        double precision,
    date_peremption DATE,
    prix_unitaire   double precision,
    id_medicament   INTEGER NOT NULL,
    id_vente        INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_medicament) REFERENCES Medicament (id),
    FOREIGN KEY (id_vente) REFERENCES Vente (id)
);

CREATE TABLE Stock
(
    id                     SERIAL,
    quantite_disponible    double precision,
    date_dernier_mouvement TIMESTAMP,
    date_peremption        DATE,
    id_medicament          INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_medicament) REFERENCES Medicament (id)
);

CREATE TABLE MvtStock
(
    id              SERIAL,
    date_mvt        TIMESTAMP,
    quantite        double precision,
    description     TEXT,
    date_peremption DATE,
    id_type_mvt     INTEGER NOT NULL,
    id_medicament   INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_type_mvt) REFERENCES Type_mvt_stock (id),
    FOREIGN KEY (id_medicament) REFERENCES Medicament (id)
);

CREATE TABLE Utilisateur
(
    id           SERIAL,
    nom          VARCHAR(100),
    prenom       VARCHAR(100),
    email        VARCHAR(255),
    mot_de_passe VARCHAR(255),
    id_role      INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_role) REFERENCES Role (id)
);

CREATE TABLE Entree_fournisseur
(
    id              SERIAL,
    quantite        double precision,
    date_peremption DATE,
    id_medicament   INTEGER NOT NULL,
    id_fournisseur  INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_medicament) REFERENCES Medicament (id),
    FOREIGN KEY (id_fournisseur) REFERENCES Fournisseur (id)
);

CREATE TABLE Medicaments_maladie
(
    id_medicament INTEGER,
    id_maladie    INTEGER,
    PRIMARY KEY (id_medicament, id_maladie),
    FOREIGN KEY (id_medicament) REFERENCES Medicament (id),
    FOREIGN KEY (id_maladie) REFERENCES Maladie (id)
);

CREATE TABLE Medicaments_Public_cible
(
    id_medicament INTEGER,
    id_public     INTEGER,
    PRIMARY KEY (id_medicament, id_public),
    FOREIGN KEY (id_medicament) REFERENCES Medicament (id),
    FOREIGN KEY (id_public) REFERENCES Public_cible (id)
);


CREATE OR REPLACE VIEW v_stock AS
(
SELECT Max(id)  as id,
       id_medicament,
       date_peremption,
       SUM(CASE
               WHEN id_type_mvt = 1 THEN quantite
               WHEN id_type_mvt = 2 THEN -quantite
               ELSE 0
           END) AS quantite_disponible
FROM mvtstock
GROUP BY id_medicament, date_peremption
    );
