-- 1. Laboratoires pharmaceutiques
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('Pharma Mada', '+261 32 11 223 34', 'Antananarivo'),
       ('Tropical Health', '+261 34 55 667 78', 'Toamasina'),
       ('Labo Aro', '+261 33 99 887 76', 'Antsirabe'),
       ('Sanofi Mada', '+261 32 44 556 65', 'Mahajanga'),
       ('Pharmakara', '+261 34 12 343 43', 'Fianarantsoa');

-- 2. Maladies courantes
INSERT INTO Maladie (nom, description)
VALUES ('Bilharziose', 'Infection parasitaire des eaux douces'),
       ('Typhoïde', 'Fièvre entérique'),
       ('Anémie', 'Carence en fer'),
       ('Grippe', 'Infection virale respiratoire'),
       ('Asthme', 'Affection respiratoire chronique');

-- 3. Publics cibles
INSERT INTO Public_cible (categorie)
VALUES ('Nourrissons'),
       ('Enfants <5 ans'),
       ('Femmes allaitantes'),
       ('Patients diabétiques'),
       ('Personnes immunodéprimées');

-- 4. Types de mouvement de stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Réapprovisionnement', 'Commande fournisseur'),
       ('Retour client', 'Produit retourné'),
       ('Dotation', 'Transfert entre pharmacies'),
       ('Perte', 'Produit endommagé');

-- 5. Rôles utilisateurs
INSERT INTO Role (nom, description)
VALUES ('Gestionnaire stock', 'Gestion des inventaires'),
       ('Caissier', 'Encaissement des ventes'),
       ('Superviseur', 'Contrôle des opérations'),
       ('Comptable', 'Gestion financière');

-- 6. Fournisseurs locaux
INSERT INTO Fournisseur (nom, contact)
VALUES ('Grossiste Atsimo', '032 89 012 34'),
       ('DistriPharma', '034 56 789 01'),
       ('Santé Plus', '033 12 098 76'),
       ('MédiImport', '032 34 567 89'),
       ('PharmaNord', '034 76 543 21');

-- 7. Unités de mesure
INSERT INTO Unite (nom, description)
VALUES ('Gélule', 'Unité de gélule'),
       ('Pommade', 'Grammes'),
       ('Sirop', 'Millilitres'),
       ('Inhalateur', 'Doses');

-- 8. Catégories produits
INSERT INTO Categorie (nom, description)
VALUES ('Antihistaminiques', 'Contre les allergies'),
       ('Antidiarrhéiques', 'Troubles digestifs'),
       ('Antifongiques', 'Infections fongiques'),
       ('Cardiovasculaires', 'Traitements cardiaques');

-- 9. Méthodes administration
INSERT INTO Administration (nom)
VALUES ('Sublinguale'),
       ('Inhalation'),
       ('Suppositoire'),
       ('Collyre');

-- 10. Sexes
INSERT INTO Sexe (nom, description)
VALUES ('Non précisé', 'Non renseigné'),
       ('Enfant', 'Pour les mineurs');

-- 11. Paramètres système
INSERT INTO Parametre (cle, valeur, description)
VALUES ('seuil_minimum', 30, 'Marge bénéficiaire standard'),
       ('taux_commission', 5, 'Pourcentage commission vendeur');

-- 12. Produits pharmaceutiques
INSERT INTO Produit (nom, description, prix, perissable, id_administration, id_unite, id_categorie, id_laboratoire)
VALUES ('Doliprane 1000mg', 'Paracétamol haute dose', 500, false, 1, 1, 2, 2),
       ('Zinc 20mg', 'Traitement diarrhée', 300, true, 1, 1, 5, 4),
       ('Salbutamol', 'Traitement asthme', 2500, false, 4, 4, 7, 3),
       ('Ferrous sulfate', 'Complément en fer', 1200, false, 1, 3, 3, 5),
       ('Praziquantel', 'Traitement bilharziose', 4200, true, 1, 1, 1, 1);

-- 13. Mouvements de stock
INSERT INTO Mvt_stock (date_mvt, quantite, description, date_peremption, id_type_mvt, id_produit)
VALUES ('2024-03-01 08:00:00', 500, 'Stock initial T1', '2025-06-30', 1, 5),
       ('2024-03-15 14:30:00', -20, 'Vente en gros', NULL, 2, 3),
       ('2024-04-01 10:15:00', 200, 'Livraison Q2', '2024-12-15', 1, 2),
       ('2024-05-20 16:45:00', -5, 'Produit endommagé', NULL, 6, 4);

-- 14. Utilisateurs
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Ramarosoa', 'Lanto', 'lanto.admin@pharmamada.mg', 'M@d@P@ss2024', 1),
       ('Rakotondrazaka', 'Tiana', 'tiana.caisse@pharmamada.mg', 'T1anaPharma!', 4),
       ('Randriamampianina', 'Jean', 'jean.superviseur@pharmamada.mg', 'Superviseur123', 5);

-- 15. Entrées fournisseurs
INSERT INTO Entree_fournisseur (quantite, date_peremption, date_entree, id_produit, id_fournisseur)
VALUES (150, '2025-03-01', '2024-02-15 09:00:00', 5, 3),
       (300, '2024-11-30', '2024-03-10 11:30:00', 2, 5),
       (75, '2026-01-01', '2024-04-01 14:00:00', 3, 2);

-- 16. Conseils produits
INSERT INTO Produit_conseil (description, date_debut, date_fin, id_produit)
VALUES ('Cure de zinc saison sèche', '2024-05-01', '2024-08-31', 2),
       ('Prévention bilharziose', '2024-01-01', '2024-12-31', 5);

-- 17. Vendeurs
INSERT INTO Vendeur (nom, prenom, email, id_sexe)
VALUES ('Rasolofoniaina', 'Niry', 'niry.vendeur@pharmamada.mg', 2),
       ('Andriamanjato', 'Tovo', 'tovo.sales@pharmamada.mg', 1),
       ('Raharimalala', 'Sitraka', 'sitraka.vd@pharmamada.mg', 2);

-- 18. Clients
INSERT INTO Client (nom, prenom)
VALUES ('Rakotomalala', 'Hery'),
       ('Randriamanantena', 'Voahangy'),
       ('Razafindrakoto', 'Mamy'),
       ('Rasolondraibe', 'Tahina');

-- 19. Ventes
INSERT INTO Vente (date_vente, montant_total, commission, id_vendeur, id_client)
VALUES ('2024-03-05 10:15:00', 0, 0, 1, 3),
       ('2024-04-18 15:30:00', 0, 0, 2, 1),
       ('2024-05-02 09:45:00', 0, 0, 3, 4);

-- 20. Détails ventes
INSERT INTO Vente_detail (quantite, date_peremption, prix_unitaire, id_produit, id_vente)
VALUES (3, '2025-06-30', 4200, 5, 1),
       (10, '2024-12-15', 300, 2, 2),
       (2, '2026-01-01', 2500, 3, 3),
       (5, '2025-03-01', 500, 1, 1);

-- 21. Associations produits-maladies
INSERT INTO Produit_maladie
VALUES (2, 3), -- Zinc contre diarrhée
       (5, 2), -- Praziquantel contre bilharziose
       (4, 5), -- Fer contre anémie
       (3, 6);
-- Salbutamol contre asthme

-- 22. Publics cibles produits
INSERT INTO Produit_public_cible
VALUES (5, 1), -- Praziquantel pour enfants
       (3, 5), -- Salbutamol pour immunodéprimés
       (2, 2), -- Zinc pour enfants <5 ans
       (4, 4); -- Fer pour femmes enceintes