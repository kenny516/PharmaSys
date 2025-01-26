-- Administration
INSERT INTO Administration ( nom)
VALUES ( 'Orale'),
       ( 'Cutanée'),
       ( 'Nasale'),
       ( 'Injection'),
       ( 'Oculaire');

-- Unite
INSERT INTO Unite ( nom, description)
VALUES ( 'Comprimé', 'Forme solide'),
       ( 'Flacon', 'Conditionné en flacons'),
       ( 'Sachet', 'Poudre en sachet'),
       ( 'Gel', 'Forme semi-solide'),
       ( 'Sirop', 'Forme liquide sucrée');

-- Categorie
INSERT INTO Categorie ( nom, description)
VALUES ('Antibiotique', 'Traite les infections bactériennes'),
       ( 'Antidouleur', 'Soulage la douleur'),
       ( 'Antipyrétique', 'Baisse la fièvre'),
       ( 'Vitamines', 'Apport complémentaire'),
       ( 'Antihistaminique', 'Lutte contre les allergies');

-- Laboratoire
INSERT INTO Laboratoire ( nom, telephone, adresse)
VALUES ( 'Sanofi', '+261341010303', 'Rue Rainilaiarivony, Tana'),
       ( 'Boiron', '+261320202101', 'Av. Rabemananjara, Fianar'),
       ( 'Merck', '+261330303202', 'Bd Ratsimandrava, Majunga'),
       ('Pharmivo', '+261345678900', 'Lot IVK, Toamasina'),
       ( 'Galenika', '+261330553322', 'Av. de l’Indépendance, Tana');

-- Maladie
INSERT INTO Maladie ( nom, description)
VALUES ( 'Grippe', 'Infection virale'),
       ( 'Diabète', 'Excès de glucose sanguin'),
       ( 'Hypertension', 'Haute pression sanguine'),
       ( 'Allergie', 'Réaction immunitaire excessive'),
       ( 'Migraine', 'Forte céphalée');

-- Public_cible
INSERT INTO Public_cible ( categorie)
VALUES ( 'Enfant'),
       ( 'Adulte'),
       ( 'Femme enceinte'),
       ( 'Personne agée'),
       ( 'Adolescent');

-- Type_mvt_stock
INSERT INTO Type_mvt_stock ( nom, description)
VALUES ( 'Entrée', 'Ajout au stock'),
       ( 'Sortie', 'Retrait du stock'),
       ( 'Retour', 'Retour stock');

-- Role
INSERT INTO Role ( nom, description)
VALUES ( 'Admin', 'Gère tout le système'),
       ( 'Pharmacien', 'Gère le stock et les ventes'),
       ( 'Caissier', 'Procède à l’encaissement');

-- Fournisseur
INSERT INTO Fournisseur ( nom, contact)
VALUES ( 'Fournisseur Mada', '+261345550101'),
       ('Fournisseur Premium', '+261320440202'),
       ( 'Fournisseur Rapide', '+261330770330'),
       ( 'Fournisseur Sud', '+261340112233'),
       ( 'Fournisseur Nord', '+261320334455');

-- Sexe
INSERT INTO Sexe ( nom, description)
VALUES ( 'Masculin', 'Homme'),
       ('Féminin', 'Femme');

-- Parametre
INSERT INTO Parametre (cle, valeur, description)
VALUES ('seuil_minimum', 200, 'Seuil minimum pour obtenir une commission pour une vente'),
       ('taux_commission', 0.15, 'Taux de commission pour une vente');

-- Client
INSERT INTO Client ( nom, prenom)
VALUES ( 'Rakoto', 'Jean'),
       ('Rasoarimalala', 'Fara'),
       ( 'Andrianina', 'Haja'),
       ( 'Raharison', 'Marina'),
       ( 'Razafindrabe', 'Malala');

-- Produit
INSERT INTO Produit ( nom, description, prix, perissable, id_administration, id_unite, id_categorie, id_laboratoire)
VALUES ( 'Paracétamol', 'Antipyrétique commun', 1000, false, 1, 1, 3, 1),
       ( 'Amoxicilline', 'Antibiotique à large spectre', 2500, false, 1, 1, 1, 2),
       ( 'Vitamine C', 'Soutient le système immunitaire', 1500, false, 1, 5, 4, 3),
       ( 'Ibuprofène', 'Anti-inflammatoire', 2000, false, 1, 1, 2, 4),
       ( 'Loratadine', 'Antihistaminique', 3000, false, 2, 1, 5, 5);

-- Mvt_stock
INSERT INTO Mvt_stock ( date_mvt, quantite, description, date_peremption, id_type_mvt, id_produit)
VALUES ( NOW(), 50, 'Arrivage Paracétamol', '2024-12-31', 1, 1),
       ( NOW(), 20, 'Sortie Amoxicilline', '2025-06-30', 2, 2),
       ( NOW(), 80, 'Arrivage Vitamine C', '2023-09-15', 1, 3),
       ( NOW(), 10, 'Retour Ibuprofène défectueux', '2023-10-10', 3, 4),
       ( NOW(), 40, 'Sortie Loratadine', '2025-03-31', 2, 5);

-- Utilisateur
INSERT INTO Utilisateur ( nom, prenom, email, mot_de_passe, id_role)
VALUES ('Randriamihaja', 'Tina', 'tina@example.com', 'pass123', 1),
       ( 'Ranaivo', 'Dina', 'dina@example.com', 'secret', 2),
       ( 'Rakotovao', 'Micka', 'micka@example.com', 'pwd123', 3),
       ( 'Razafy', 'Hery', 'hery@example.com', 'azert', 2),
       ('Andrianarisoa', 'Zo', 'zo@example.com', 'qwerty', 1);

-- Entree_fournisseur
INSERT INTO Entree_fournisseur ( quantite, date_peremption, date_entree, id_produit, id_fournisseur)
VALUES  (100, '2024-08-31', NOW(), 1, 1),
       ( 150, '2025-10-15', NOW(), 2, 2),
       ( 80, '2023-12-30', NOW(), 3, 3),
       ( 120, '2025-05-01', NOW(), 4, 4),
       ( 60, '2023-11-15', NOW(), 5, 5);

-- Produit_conseil
INSERT INTO Produit_conseil ( description, date_debut, date_fin, id_produit)
VALUES ( 'Prendre après repas', '2023-01-01', '2023-12-31', 1),
       ( 'Respecter la dose prescrite', '2023-02-15', '2023-09-30', 2),
       ( 'Boire suffisamment d’eau', '2023-04-01', '2023-12-01', 3),
       ( 'Ne pas dépasser 6 comprimés/jour', '2023-05-10', '2023-12-10', 4),
       ( 'Éviter la conduite', '2023-06-20', '2023-12-20', 5);

-- Vendeur
INSERT INTO Vendeur ( nom, prenom, email, id_sexe)
VALUES ( 'Randrianarivo', 'Arisoa', 'arisoa@example.com', 2),
       ( 'Ramarozaka', 'Michel', 'michel@example.com', 1),
       ( 'Raoelina', 'Hoby', 'hoby@example.com', 2),
       ( 'Razafindramavo', 'Lova', 'lova@example.com', 1),
       ( 'Ranjakamalala', 'Dany', 'dany@example.com', 2);

-- Vente
INSERT INTO Vente ( date_vente, montant_total, commission, id_vendeur, id_client)
VALUES ( NOW(), 0, 0, 1, 1),
       ( NOW(), 0, 0, 2, 2),
       ( NOW(), 0, 0, 3, 3),
       ( NOW(), 0, 0, 4, 4),
       ( NOW(), 0, 0, 5, 5);

-- Vente_detail
INSERT INTO Vente_detail ( quantite, date_peremption, prix_unitaire, id_produit, id_vente)
VALUES (1, '2024-12-31', 1000, 1, 1),
       ( 1, '2025-06-30', 2500, 2, 2),
       ( 2, '2023-09-15', 1500, 3, 3),
       ( 1, '2023-10-10', 2000, 4, 4),
       ( 1, '2025-03-31', 3000, 5, 5);

-- Produit_maladie
INSERT INTO Produit_maladie (id_produit, id_maladie)
VALUES (1, 3),
       (2, 1),
       (3, 2),
       (4, 5),
       (5, 4);

-- Produit_public_cible
INSERT INTO Produit_public_cible (id_produit, id_public)
VALUES (1, 2),
       (2, 1),
       (3, 4),
       (4, 5),
       (5, 3);