-- Insertion dans la table Laboratoire
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('Laboratoire Pharma', '0123456789', '123 Rue Principale'),
       ('Laboratoire Medicinal', '0987654321', '45 Avenue des Sciences'),
       ('Laboratoire Biohealth', '0543219876', '89 Boulevard Santé');

-- Insertion dans la table Maladie
INSERT INTO Maladie (nom, description)
VALUES ('Diabete', 'Maladie chronique affectant le metabolisme du glucose'),
       ('Hypertension', 'Augmentation anormale de la pression arterielle'),
       ('Grippe', 'Infection virale des voies respiratoires');

-- Insertion dans la table Vente
INSERT INTO Vente (date_vente, montant_total)
VALUES ('2025-01-07 10:15:00', 150.75),
       ('2025-01-07 14:30:00', 80.50),
       ('2025-01-08 09:00:00', 200.00);

-- Insertion dans la table Public_cible
INSERT INTO Public_cible (categorie)
VALUES ('Adultes'),
       ('Enfants'),
       ('Seniors');

-- Insertion dans la table Type_mvt_stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Entree', 'Ajout de produits dans le stock'),
       ('Sortie', 'Retrait de produits du stock'),
       ('Ajustement', 'Correction du stock');

-- Insertion dans la table Role
INSERT INTO Role (nom, description)
VALUES ('Administrateur', 'Gestionnaire du systeme'),
       ('Pharmacien', 'Gestion des ventes et du stock'),
       ('Assistant', 'Support pour les taches quotidiennes');

-- Insertion dans la table Fournisseur
INSERT INTO Fournisseur (nom, contact)
VALUES ('Pharma Distrib', '0321654987'),
       ('Medi Supply', '0423765908'),
       ('Sante Plus', '0523654789');

-- Insertion dans la table Unite
INSERT INTO Unite (nom, description)
VALUES ('Boite', 'Unite de mesure pour les produits en boite'),
       ('Flacon', 'Unite de mesure pour les produits liquides'),
       ('Plaquette', 'Unite de mesure pour les comprimes');

-- Insertion dans la table Categorie
INSERT INTO Categorie (nom, description)
VALUES ('Medicament', 'Medicaments pour traiter les infections bacteriennes'),
       ('outils Medical', 'Medicaments contre la douleur'),
       ('desinfectant', 'Medicaments pour la pression arterielle');

-- Insertion dans la table Produit
INSERT INTO Produit (nom, description, prix, perissable, id_unite, id_categorie, id_laboratoire)
VALUES ('Paracetamol', 'Analgésique et antipyrétique', 5.50, FALSE, 3, 2, 1),
       ('Amoxicilline', 'Antibiotique large spectre', 10.00, TRUE, 1, 1, 2),
       ('Captopril', 'Traitement de l hypertension', 8.00, FALSE, 1, 3, 3);

-- Insertion dans la table Vente_detail
INSERT INTO Vente_detail (quantite, date_peremption, prix_unitaire, id_produit, id_vente)
VALUES (2, '2026-01-01', 5.50, 1, 1),
       (1, '2026-06-01', 10.00, 2, 2),
       (3, NULL, 8.00, 3, 3);

-- Insertion dans la table Mvt_stock
INSERT INTO Mvt_stock (date_mvt, quantite, description, date_peremption, id_type_mvt, id_produit)
VALUES ('2025-01-01 08:00:00', 100, 'Reception de stock', '2026-01-01', 1, 1),
       ('2025-01-05 10:00:00', 50, 'Vente de stock', NULL, 2, 2),
       ('2025-01-07 12:00:00', -5, 'Correction d inventaire', NULL, 3, 3);

-- Insertion dans la table Utilisateur
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Admin', 'Systeme', 'admin@pharma.local', 'password', 1),
       ('Dupont', 'Jean', 'jean.dupont@pharma.local', 'password', 2),
       ('Martin', 'Claire', 'claire.martin@pharma.local', 'password', 3);

-- Insertion dans la table Entree_fournisseur
INSERT INTO Entree_fournisseur (quantite, date_peremption, id_produit, id_fournisseur)
VALUES (100, '2026-01-01', 1, 1),
       (200, '2026-06-01', 2, 2),
       (150, '2026-12-01', 3, 3);

-- Insertion dans la table Produit_maladie
INSERT INTO Produit_maladie (id_produit, id_maladie)
VALUES (1, 3),
       (2, 1),
       (3, 2);

-- Insertion dans la table Produit_public_cible
INSERT INTO Produit_public_cible (id_produit, id_public)
VALUES (1, 2),
       (2, 1),
       (3, 3);
