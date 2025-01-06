-- Inserer des donnees dans la table Laboratoire
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('Pfizer', '0123456789', 'New York, USA'),
       ('Sanofi', '0987654321', 'Paris, France'),
       ('Novartis', '1234567890', 'Basel, Switzerland');

-- Inserer des donnees dans la table Maladie
INSERT INTO Maladie (nom, description)
VALUES ('Diabete', 'Maladie chronique caracterisee par une hyperglycemie persistante.'),
       ('Hypertension', 'elevation persistante de la pression arterielle.'),
       ('Grippe', 'Infection virale qui attaque le systeme respiratoire.');

-- Inserer des donnees dans la table Type_mvt_stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Entree', 'Ajout de produits au stock'),
       ('Sortie', 'Retrait de produits du stock');

-- Inserer des donnees dans la table Role
INSERT INTO Role (nom, description)
VALUES ('Admin', 'Administrateur avec tous les privileges'),
       ('Pharmacien', 'Gestionnaire des ventes et du stock'),
       ('Client', 'Utilisateur achetant des produits.');

-- Inserer des donnees dans la table Public_cible
INSERT INTO Public_cible (categorie)
VALUES ('Enfants'),
       ('Adultes'),
       ('Personnes âgees');

-- Inserer des donnees dans la table Fournisseur
INSERT INTO Fournisseur (nom, contact)
VALUES ('MedSupply Co', 'medsupply@example.com'),
       ('Global Pharma', 'globalpharma@example.com'),
       ('HealthLine', 'contact@healthline.com');

-- Inserer des donnees dans la table Medicament
INSERT INTO Medicament (nom, description, prix, id_laboratoire)
VALUES ('Doliprane', 'Antidouleur et antipyretique', 5.50, 2),
       ('Insuline', 'Traitement du diabete', 20.00, 1),
       ('Aspirine', 'Soulage la douleur et reduit la fievre', 3.00, 3);

-- Inserer des donnees dans la table Vente
INSERT INTO Vente (date_vente, montant_total)
VALUES ('2025-01-01 10:30:00', 55.00),
       ('2025-01-03 15:45:00', 30.00),
       ('2025-01-04 12:00:00', 20.00);

-- Inserer des donnees dans la table Vente_detail
INSERT INTO Vente_detail (quantite, date_peremption, prix_unitaire, id_medicament, id_vente)
VALUES (2, '2025-12-31', 5.50, 1, 1),
       (1, '2025-06-30', 20.00, 2, 1),
       (1, '2026-01-01', 30.00, 3, 2);

-- Inserer des donnees dans la table Stock
INSERT INTO Stock (quantite_disponible, date_dernier_mouvement, date_peremption, id_medicament)
VALUES (100, '2025-01-01 09:00:00', '2025-12-31', 1),
       (50, '2025-01-01 09:00:00', '2025-06-30', 2),
       (30, '2025-01-01 09:00:00', '2026-01-01', 3);

-- Inserer des donnees dans la table MvtStock
INSERT INTO MvtStock (date_mvt, quantite, description, date_peremption, id_type_mvt, id_medicament)
VALUES ('2025-01-01 09:00:00', 100, 'Reception initiale', '2025-12-31', 1, 1),
       ('2025-01-01 09:00:00', 50, 'Reception initiale', '2025-06-30', 1, 2),
       ('2025-01-01 09:00:00', 30, 'Reception initiale', '2026-01-01', 1, 3);

-- Inserer des donnees dans la table Utilisateur
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Doe', 'John', 'john.doe@example.com', 'password123', 1),
       ('Smith', 'Anna', 'anna.smith@example.com', 'password456', 2),
       ('Brown', 'James', 'james.brown@example.com', 'password789', 3);

-- Inserer des donnees dans la table Entree_fournisseur
INSERT INTO Entree_fournisseur (quantite, date_peremption, id_medicament, id_fournisseur)
VALUES (100, '2025-12-31', 1, 1),
       (50, '2025-06-30', 2, 2),
       (30, '2026-01-01', 3, 3);

-- Inserer des donnees dans la table Medicaments_maladie
INSERT INTO Medicaments_maladie (id_medicament, id_maladie)
VALUES (1, 3),
       (2, 1),
       (3, 2);

-- Inserer des donnees dans la table Medicaments_Public_cible
INSERT INTO Medicaments_Public_cible (id_medicament, id_public)
VALUES (1, 2),
       (2, 3),
       (3, 2);
