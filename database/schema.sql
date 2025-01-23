CREATE
DATABASE pharma_sys;
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

CREATE TABLE Fournisseur
(
    id      SERIAL,
    nom     VARCHAR(50),
    contact VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Unite
(
    id          SERIAL,
    nom         VARCHAR(50),
    description TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE Categorie
(
    id          SERIAL,
    nom         VARCHAR(50),
    description TEXT,
    PRIMARY KEY (id),
    UNIQUE (nom)
);

CREATE TABLE Administration
(
    id  SERIAL,
    nom VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Client
(
    id     SERIAL,
    nom    VARCHAR(50) NOT NULL,
    prenom VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Sexe
(
    id     SERIAL PRIMARY KEY ,
    nom    VARCHAR(50),
    description varchar(255)
);

CREATE TABLE Vendeur
(
    id     SERIAL,
    nom    VARCHAR(50),
    prenom VARCHAR(50),
    email varchar(255),
    id_sexe INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_sexe) REFERENCES Sexe(id)
);

CREATE TABLE Produit
(
    id                SERIAL,
    nom               VARCHAR(50),
    description       TEXT,
    prix              DOUBLE PRECISION,
    perissable        BOOLEAN default false,
    id_administration INTEGER NOT NULL,
    id_unite          INTEGER NOT NULL,
    id_categorie      INTEGER NOT NULL,
    id_laboratoire    INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (id_administration) REFERENCES Administration (id),
    FOREIGN KEY (id_unite) REFERENCES Unite (id),
    FOREIGN KEY (id_categorie) REFERENCES Categorie (id),
    FOREIGN KEY (id_laboratoire) REFERENCES Laboratoire (id)
);

CREATE TABLE Vente
(
    id            SERIAL,
    date_vente    TIMESTAMP,
    montant_total DOUBLE PRECISION,
    id_vendeur    INTEGER NOT NULL,
    id_client     INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_vendeur) REFERENCES Vendeur (id),
    FOREIGN KEY (id_client) REFERENCES Client (id)
);

CREATE TABLE Vente_detail
(
    id              SERIAL,
    quantite        DOUBLE PRECISION,
    date_peremption DATE,
    prix_unitaire   DOUBLE PRECISION,
    id_produit      INTEGER NOT NULL,
    id_vente        INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_produit) REFERENCES Produit (id),
    FOREIGN KEY (id_vente) REFERENCES Vente (id)
);

CREATE TABLE Mvt_stock
(
    id              SERIAL,
    date_mvt        TIMESTAMP,
    quantite        DOUBLE PRECISION,
    description     TEXT,
    date_peremption DATE,
    id_type_mvt     INTEGER NOT NULL,
    id_produit      INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_type_mvt) REFERENCES Type_mvt_stock (id),
    FOREIGN KEY (id_produit) REFERENCES Produit (id)
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
    quantite        DOUBLE PRECISION,
    date_peremption DATE,
    date_entree     TIMESTAMP,
    id_produit      INTEGER NOT NULL,
    id_fournisseur  INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_produit) REFERENCES Produit (id),
    FOREIGN KEY (id_fournisseur) REFERENCES Fournisseur (id)
);

CREATE TABLE Produit_conseil
(
    id          SERIAL,
    description VARCHAR(50),
    date_debut  DATE,
    date_fin    DATE,
    id_produit  INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_produit) REFERENCES Produit (id)
);

CREATE TABLE Produit_maladie
(
    id_produit INTEGER,
    id_maladie INTEGER,
    PRIMARY KEY (id_produit, id_maladie),
    FOREIGN KEY (id_produit) REFERENCES Produit (id),
    FOREIGN KEY (id_maladie) REFERENCES Maladie (id)
);

CREATE TABLE Produit_public_cible
(
    id_produit INTEGER,
    id_public  INTEGER,
    PRIMARY KEY (id_produit, id_public),
    FOREIGN KEY (id_produit) REFERENCES Produit (id),
    FOREIGN KEY (id_public) REFERENCES Public_cible (id)
);



