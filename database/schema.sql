CREATE TABLE Laboratoires
(
    id        INTEGER,
    nom       VARCHAR(50),
    telephone VARCHAR(50),
    adresse   VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Maladies
(
    id          INTEGER,
    nom         VARCHAR(50),
    description TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE Ventes
(
    id            INTEGER,
    date_vente    TIMESTAMP,
    montant_total NUMERIC(15, 2),
    PRIMARY KEY (id)
);

CREATE TABLE PublicCible
(
    id        INTEGER,
    categorie VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Type_mvt_stock
(
    id          INTEGER,
    nom         VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE (nom)
);

CREATE TABLE Role
(
    id          INTEGER,
    nom         VARCHAR(50),
    description VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE (nom)
);

CREATE TABLE Medicaments
(
    id             INTEGER,
    nom            VARCHAR(50),
    description    TEXT,
    prix           NUMERIC(15, 2),
    id_laboratoire INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (id_laboratoire) REFERENCES Laboratoires (id)
);

CREATE TABLE VenteDetails
(
    id            INTEGER,
    quantite      INTEGER,
    prix_unitaire NUMERIC(15, 2),
    id_medicament INTEGER NOT NULL,
    id_vente      INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_medicament) REFERENCES Medicaments (id),
    FOREIGN KEY (id_vente) REFERENCES Ventes (id)
);

CREATE TABLE Stocks
(
    id                     INTEGER,
    quantite_disponible    NUMERIC(15, 2),
    date_dernier_mouvement TIMESTAMP,
    date_peremption        DATE,
    id_medicament          INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_medicament) REFERENCES Medicaments (id)
);

CREATE TABLE MvtStock
(
    id            INTEGER,
    date_mvt      TIMESTAMP,
    quantite      INTEGER,
    description   TEXT,
    id_type_mvt   INTEGER NOT NULL,
    id_medicament INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_type_mvt) REFERENCES Type_mvt_stock (id),
    FOREIGN KEY (id_medicament) REFERENCES Medicaments (id)
);

CREATE TABLE Utilisateur
(
    id           INTEGER,
    nom          VARCHAR(100),
    prenom       VARCHAR(100),
    email        VARCHAR(255),
    mot_de_passe VARCHAR(255),
    id_role      INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_role) REFERENCES Role (id)
);

CREATE TABLE Medicaments_maladies
(
    id_medicament INTEGER,
    id_maladie    INTEGER,
    PRIMARY KEY (id_medicament, id_maladie),
    FOREIGN KEY (id_medicament) REFERENCES Medicaments (id),
    FOREIGN KEY (id_maladie) REFERENCES Maladies (id)
);

CREATE TABLE Medicaments_PublicCible
(
    id_medicament INTEGER,
    id_public     INTEGER,
    PRIMARY KEY (id_medicament, id_public),
    FOREIGN KEY (id_medicament) REFERENCES Medicaments (id),
    FOREIGN KEY (id_public) REFERENCES PublicCible (id)
);
