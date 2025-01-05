-- Table Laboratoire
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('Laboratoire Roche', '0321010203', 'Antananarivo, Madagascar'),
       ('Laboratoire Sanofi', '0323030405', 'Toamasina, Madagascar'),
       ('Laboratoire Pfizer', '0325050607', 'Fianarantsoa, Madagascar');

-- Table Maladie
INSERT INTO Maladie (nom, description)
VALUES ('Hypertension', 'Pression arterielle elevee nécessitant un traitement regulier.'),
       ('Diabète', 'Maladie chronique liee a un exces de glucose dans le sang.'),
       ('Grippe', 'Infection virale commune causant fievre et fatigue.');

-- Table PublicCible
INSERT INTO PublicCible (categorie)
VALUES ('Enfants'),
       ('Adultes'),
       ('Toutes');

-- Table Type_mvt_stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Entree', 'Ajout de nouveaux produits en stock'),
       ('Sortie', 'Sortie de produits suite à une vente'),
       ('Correction', 'Mouvement de stock pour corriger une erreur');

-- Table Role
INSERT INTO Role (nom, description)
VALUES ('Admin', 'Gère le systeme et les utilisateurs'),
       ('Pharmacien', 'Gere les ventes et les stocks'),
       ('Caissier', 'Gère les encaissements des clients');

-- Table Medicament
INSERT INTO Medicament (nom, description, prix, id_laboratoire)
VALUES ('Paracétamol', 'Antalgique pour réduire les douleurs et la fievre.', 2000.00, 1),
       ('Ibuprofène', 'Anti-inflammatoire et analgesique.', 3500.00, 2),
       ('Insuline', 'Traitement pour le diabete.', 15000.00, 3);

-- Table Vente
INSERT INTO Vente (date_vente, montant_total)
VALUES ('2024-12-28 10:30:00', 5500.00),
       ('2024-12-28 15:45:00', 20000.00);

-- Table VenteDetail
INSERT INTO VenteDetail (quantite, prix_unitaire, id_medicament, id_vente)
VALUES (2, 2000.00, 1, 1),
       (1, 15000.00, 3, 2);

-- Table Stock
INSERT INTO Stock (quantite_disponible, date_dernier_mouvement, date_peremption, id_medicament)
VALUES (100, '2024-12-01 09:00:00', '2025-12-31', 1),
       (50, '2024-12-01 09:00:00', '2025-06-30', 2),
       (20, '2024-12-01 09:00:00', '2026-01-15', 3);

-- Table MvtStock
INSERT INTO MvtStock (date_mvt, quantite, description, id_type_mvt, id_medicament)
VALUES ('2024-12-01 09:00:00', 50, 'Ajout initial de stock', 1, 1),
       ('2024-12-28 15:45:00', -1, 'Vente', 2, 3);

-- Table Utilisateur
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Randria', 'Jean', 'jean.randria@example.com', 'password123', 1),
       ('Rakoto', 'Marie', 'marie.rakoto@example.com', 'password456', 2),
       ('Andrianiaina', 'Paul', 'paul.andrianiaina@example.com', 'password789', 3);

-- Table Medicaments_maladies
INSERT INTO Medicaments_maladies (id_medicament, id_maladie)
VALUES (1, 3), -- Paracétamol pour la grippe
       (3, 2);
-- Insuline pour le diabète

-- Table Medicaments_PublicCible
INSERT INTO Medicaments_PublicCible (id_medicament, id_public)
VALUES (1, 2), -- Paracétamol pour les adultes
       (2, 3), -- Ibuprofène pour les seniors
       (3, 3); -- Insuline pour les seniors
