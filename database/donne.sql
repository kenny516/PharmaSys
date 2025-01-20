DROP DATABASE IF EXISTS pharma_sys;
CREATE DATABASE pharma_sys;
\c pharma_sys;

------------------------- Donne de base

-- Laboratoires pharmaceutiques
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('Sanofi', '+261341234567', 'Antananarivo, Madagascar'),
       ('Pfizer', '+261341234568', 'Antsirabe, Madagascar'),
       ('Novartis', '+261341234569', 'Toamasina, Madagascar'),
       ('Bayer', '+261341234570', 'Fianarantsoa, Madagascar'),
       ('GSK', '+261341234571', 'Mahajanga, Madagascar');

-- Maladies courantes
INSERT INTO Maladie (nom, description)
VALUES ('Hypertension', 'Pression artérielle élevée chronique'),
       ('Diabète Type 2', 'Trouble du métabolisme du glucose'),
       ('Migraine', 'Céphalées récurrentes avec symptômes neurologiques'),
       ('Arthrose', 'Dégénérescence des articulations'),
       ('Asthme', 'Maladie inflammatoire des voies respiratoires');

-- Catégories de produits
INSERT INTO Categorie (nom, description)
VALUES ('Antibiotiques', 'Médicaments qui combattent les infections bactériennes'),
       ('Analgésiques', 'Médicaments contre la douleur'),
       ('Anti-inflammatoires', 'Réduction de l''inflammation'),
       ('Antidiabétiques', 'Traitement du diabète'),
       ('Vitamines', 'Compléments alimentaires');

-- Unités de mesure
INSERT INTO Unite (nom, description)
VALUES ('Comprimé', 'Forme solide unique'),
       ('Flacon', 'Contenant liquide'),
       ('Gélule', 'Capsule à enveloppe dure'),
       ('Ampoule', 'Dose unique stérile'),
       ('Sachet', 'Poudre à diluer');

-- Types de mouvements de stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Entrée', 'Approvisionnement stock'),
       ('Sortie', 'Déstockage pour vente'),
       ('Retour', 'Retour produit'),
       ('Perte', 'Perte ou casse'),
       ('Péremption', 'Retrait pour péremption');

-- Voies d'administration
INSERT INTO Administration (nom)
VALUES ('Orale'),
       ('Injectable'),
       ('Cutanée'),
       ('Nasale'),
       ('Ophtalmique');

-- Rôles utilisateurs
INSERT INTO Role (nom, description)
VALUES ('Admin', 'Administrateur système'),
       ('Pharmacien', 'Pharmacien titulaire'),
       ('Préparateur', 'Préparateur en pharmacie'),
       ('Vendeur', 'Vendeur en pharmacie'),
       ('Gestionnaire', 'Gestionnaire de stock');

-- Public cible
INSERT INTO Public_cible (categorie)
VALUES ('Adultes'),
       ('Enfants'),
       ('Personnes âgées'),
       ('Femmes enceintes'),
       ('Nourrissons');

------------------------- Donne principale

-- Produits pharmaceutiques
INSERT INTO Produit (nom, description, prix, perissable, id_administration, id_unite, id_categorie, id_laboratoire)
VALUES ('Doliprane 1000mg', 'Paracétamol pour douleurs et fièvre', 3500, true, 1, 1, 2, 1),
       ('Amoxicilline 500mg', 'Antibiotique à large spectre', 8900, true, 1, 3, 1, 2),
       ('Voltarene 50mg', 'Anti-inflammatoire puissant', 4800, true, 1, 1, 3, 3),
       ('Insuline Lantus', 'Insuline longue durée', 45900, true, 2, 4, 4, 1),
       ('Magnésium B6', 'Complément alimentaire', 6200, false, 1, 3, 5, 4);

-- Clients
INSERT INTO client (nom, prenom)
VALUES ('Rakoto', 'Jean'),
       ('Rasoanaivo', 'Sophie'),
       ('Randrianarisoa', 'Marie'),
       ('Rajaonarivelo', 'Pierre'),
       ('Ravelomanana', 'Claire');

-- Fournisseurs
INSERT INTO Fournisseur (nom, contact)
VALUES ('PharmaDist', '+261341234572'),
       ('MediSupply', '+261341234573'),
       ('EuroPharm', '+261341234574'),
       ('PharmaStock', '+261341234575'),
       ('MedLogistic', '+261341234576');

-- Utilisateurs
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Admin', 'System', 'admin@pharma.mg', 'hashedpassword1', 1),
       ('Rabe', 'Philippe', 'p.rabe@pharma.mg', 'hashedpassword2', 2),
       ('Rasoa', 'Anne', 'a.rasoa@pharma.mg', 'hashedpassword3', 3),
       ('Rakoto', 'Marc', 'm.rakoto@pharma.mg', 'hashedpassword4', 4),
       ('Ravelo', 'Julie', 'j.ravelo@pharma.mg', 'hashedpassword5', 5);

------------------------- Donne de transaction

-- Ventes
INSERT INTO Vente (id_client, date_vente, montant_total)
VALUES (1, '2024-03-10 09:15:00', 45800),
       (2, '2024-03-10 10:30:00', 32600),
       (3, '2024-03-10 11:45:00', 68900),
       (4, '2024-03-10 14:20:00', 15400),
       (5, '2024-03-10 16:00:00', 54700);

-- Détails des ventes
INSERT INTO Vente_detail (quantite, date_peremption, prix_unitaire, id_produit, id_vente)
VALUES (2, '2025-03-10', 3500, 1, 1),
       (1, '2025-06-15', 8900, 2, 1),
       (3, '2025-04-20', 4800, 3, 2),
       (1, '2024-12-31', 45900, 4, 3),
       (2, '2026-01-01', 6200, 5, 4);

-- Mouvements de stock
INSERT INTO Mvt_stock (date_mvt, quantite, description, date_peremption, id_type_mvt, id_produit)
VALUES ('2024-03-01 08:00:00', 100, 'Approvisionnement initial', '2025-03-10', 1, 1),
       ('2024-03-01 08:30:00', 50, 'Approvisionnement initial', '2025-06-15', 1, 2),
       ('2024-03-01 09:00:00', 75, 'Approvisionnement initial', '2025-04-20', 1, 3),
       ('2024-03-01 09:30:00', 30, 'Approvisionnement initial', '2024-12-31', 1, 4),
       ('2024-03-01 10:00:00', 200, 'Approvisionnement initial', '2026-01-01', 1, 5);

------------------------- Donne de liaison
-- Liaison entre produits et maladies
INSERT INTO Produit_maladie (id_produit, id_maladie)
VALUES (1, 1), -- Doliprane pour Hypertension
       (2, 2), -- Amoxicilline pour Diabète Type 2
       (3, 3), -- Voltarene pour Migraine
       (4, 4), -- Insuline Lantus pour Arthrose
       (5, 5);
-- Magnésium B6 pour Asthme

-- Liaison entre produits et public cible
INSERT INTO Produit_public_cible (id_produit, id_public)
VALUES (1, 1), -- Doliprane pour Adultes
       (2, 2), -- Amoxicilline pour Enfants
       (3, 3), -- Voltarene pour Personnes âgées
       (4, 4), -- Insuline Lantus pour Femmes enceintes
       (5, 5);
-- Magnésium B6 pour Nourrissons

-- Conseils pour les produits
INSERT INTO Produit_conseil (id_produit, date_debut, date_fin, description)
VALUES (1, '2024-01-01', '2024-12-31', 'Prendre un comprimé toutes les 6 heures en cas de douleur ou de fièvre.'),
       (2, '2024-01-01', '2024-12-31', 'Prendre une gélule toutes les 8 heures pendant 7 jours.'),
       (3, '2024-01-01', '2024-12-31', 'Appliquer une dose sur la zone douloureuse deux fois par jour.'),
       (4, '2024-01-01', '2024-12-31', 'Injecter une dose sous-cutanée une fois par jour.'),
       (5, '2024-01-01', '2024-12-31', 'Prendre une gélule par jour avec un verre d''eau.');
