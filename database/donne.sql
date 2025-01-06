-- Insérer des données dans la table Laboratoire
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('Pfizer', '0123456789', 'New York, USA'),
       ('Sanofi', '0987654321', 'Paris, France'),
       ('Novartis', '1234567890', 'Basel, Switzerland');

-- Insérer des données dans la table Maladie
INSERT INTO Maladie (nom, description)
VALUES ('Diabète', 'Maladie chronique caractérisée par une hyperglycémie persistante.'),
       ('Hypertension', 'Élévation persistante de la pression artérielle.'),
       ('Grippe', 'Infection virale qui attaque le système respiratoire.');

-- Insérer des données dans la table Type_mvt_stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Entrée', 'Ajout de produits au stock'),
       ('Sortie', 'Retrait de produits du stock');

-- Insérer des données dans la table Role
INSERT INTO Role (nom, description)
VALUES ('Admin', 'Administrateur avec tous les privilèges'),
       ('Pharmacien', 'Gestionnaire des ventes et du stock'),
       ('Client', 'Utilisateur achetant des produits.');

-- Insérer des données dans la table Public_cible
INSERT INTO Public_cible (categorie)
VALUES ('Enfants'),
       ('Adultes'),
       ('Personnes âgées');

-- Insérer des données dans la table Fournisseur
INSERT INTO Fournisseur (nom, contact)
VALUES ('MedSupply Co', 'medsupply@example.com'),
       ('Global Pharma', 'globalpharma@example.com'),
       ('HealthLine', 'contact@healthline.com');

-- Insérer des données dans la table Medicament
INSERT INTO Medicament (nom, description, prix, id_laboratoire)
VALUES ('Doliprane', 'Antidouleur et antipyrétique', 5.50, 2),
       ('Insuline', 'Traitement du diabète', 20.00, 1),
       ('Aspirine', 'Soulage la douleur et réduit la fièvre', 3.00, 3);

-- Insérer des données dans la table Vente
INSERT INTO Vente (date_vente, montant_total)
VALUES ('2025-01-01 10:30:00', 55.00),
       ('2025-01-03 15:45:00', 30.00),
       ('2025-01-04 12:00:00', 20.00);

-- Insérer des données dans la table Vente_detail
INSERT INTO Vente_detail (quantite, date_peremption, prix_unitaire, id_medicament, id_vente)
VALUES (2, '2025-12-31', 5.50, 1, 1),
       (1, '2025-06-30', 20.00, 2, 1),
       (1, '2026-01-01', 30.00, 3, 2);

-- Insérer des données dans la table Stock
INSERT INTO Stock (quantite_disponible, date_dernier_mouvement, date_peremption, id_medicament)
VALUES (100, '2025-01-01 09:00:00', '2025-12-31', 1),
       (50, '2025-01-01 09:00:00', '2025-06-30', 2),
       (30, '2025-01-01 09:00:00', '2026-01-01', 3);

-- Insérer des données dans la table MvtStock
INSERT INTO MvtStock (date_mvt, quantite, description, date_peremption, id_type_mvt, id_medicament)
VALUES ('2025-01-01 09:00:00', 100, 'Réception initiale', '2025-12-31', 1, 1),
       ('2025-01-01 09:00:00', 50, 'Réception initiale', '2025-06-30', 1, 2),
       ('2025-01-01 09:00:00', 30, 'Réception initiale', '2026-01-01', 1, 3);

-- Insérer des données dans la table Utilisateur
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Doe', 'John', 'john.doe@example.com', 'password123', 1),
       ('Smith', 'Anna', 'anna.smith@example.com', 'password456', 2),
       ('Brown', 'James', 'james.brown@example.com', 'password789', 3);

-- Insérer des données dans la table Entree_fournisseur
INSERT INTO Entree_fournisseur (quantite, date_peremption, id_medicament, id_fournisseur)
VALUES (100, '2025-12-31', 1, 1),
       (50, '2025-06-30', 2, 2),
       (30, '2026-01-01', 3, 3);

-- Insérer des données dans la table Medicaments_maladie
INSERT INTO Medicaments_maladie (id_medicament, id_maladie)
VALUES (1, 3),
       (2, 1),
       (3, 2);

-- Insérer des données dans la table Medicaments_Public_cible
INSERT INTO Medicaments_Public_cible (id_medicament, id_public)
VALUES (1, 2),
       (2, 3),
       (3, 2);
