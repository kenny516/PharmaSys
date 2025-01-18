-- Insérer des laboratoires
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('PharmaTech', '0123456789', '123 Rue de Santé, Paris'),
       ('BioCare', '0987654321', '456 Boulevard Biologique, Lyon');

-- Insérer des maladies
INSERT INTO Maladie (nom, description)
VALUES ('Diabète', 'Trouble métabolique caractérisé par une hyperglycémie.'),
       ('Hypertension', 'Pression artérielle élevée, risque accru de maladies cardiovasculaires.');

-- Insérer des ventes
INSERT INTO Vente (date_vente, montant_total)
VALUES ('2025-01-01 10:00:00', 250.50),
       ('2025-01-02 15:30:00', 150.75);

-- Insérer des publics cibles
INSERT INTO Public_cible (categorie)
VALUES ('Enfants'),
       ('Adultes');

-- Insérer des types de mouvement de stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Entrée', 'Ajout de stock.'),
       ('Sortie', 'Réduction de stock pour une vente.');

-- Insérer des rôles
INSERT INTO Role (nom, description)
VALUES ('Admin', 'Administrateur du système.'),
       ('Utilisateur', 'Utilisateur standard.');

-- Insérer des fournisseurs
INSERT INTO Fournisseur (nom, contact)
VALUES ('MediSupply', 'medisupply@example.com'),
       ('HealthSource', 'healthsource@example.com');

-- Insérer des unités
INSERT INTO Unite (nom, description)
VALUES ('Boîte', 'Emballage standard de produits pharmaceutiques.'),
       ('Flacon', 'Contenant liquide.');

-- Insérer des catégories
INSERT INTO Categorie (nom, description)
VALUES ('Antibiotiques', 'Médicaments pour combattre les infections.'),
       ('Analgésiques', 'Médicaments pour soulager la douleur.');

-- Insérer des administrations
INSERT INTO Administration (nom)
VALUES ('Orale'),
       ('Injectable');

-- Insérer des produits
INSERT INTO Produit (nom, description, prix, perissable, id_administration, id_unite, id_categorie, id_laboratoire)
VALUES ('Paracétamol', 'Analgésique courant.', 2.5, FALSE, 1, 1, 2, 1),
       ('Amoxicilline', 'Antibiotique pour infections.', 8.0, TRUE, 1, 1, 1, 2);

-- Insérer des détails de vente
INSERT INTO Vente_detail (quantite, date_peremption, prix_unitaire, id_produit, id_vente)
VALUES (2, '2026-12-31', 2.5, 1, 1),
       (1, '2025-06-30', 8.0, 2, 2);

-- Insérer des mouvements de stock
INSERT INTO Mvt_stock (date_mvt, quantite, description, date_peremption, id_type_mvt, id_produit)
VALUES ('2025-01-01 09:00:00', 100, 'Stock initial.', '2026-12-31', 1, 1),
       ('2025-01-02 09:00:00', 50, 'Stock initial.', '2025-06-30', 1, 2);

-- Insérer des utilisateurs
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Dupont', 'Jean', 'jean.dupont@example.com', 'password123', 1),
       ('Martin', 'Sophie', 'sophie.martin@example.com', 'securepass', 2);

-- Insérer des entrées fournisseurs
INSERT INTO Entree_fournisseur (quantite, date_peremption, date_entree, id_produit, id_fournisseur)
VALUES (100, '2026-12-31', '2025-01-01 08:00:00', 1, 1),
       (50, '2025-06-30', '2025-01-02 08:00:00', 2, 2);

-- Associer produits et maladies
INSERT INTO Produit_maladie (id_produit, id_maladie)
VALUES (1, 2), -- Paracétamol pour Hypertension
       (2, 1);
-- Amoxicilline pour Diabète

-- Associer produits et publics cibles
INSERT INTO Produit_public_cible (id_produit, id_public)
VALUES (1, 2), -- Paracétamol pour Adultes
       (2, 1); -- Amoxicilline pour Enfants

INSERT INTO Produit_conseil (id_produit, date_debut, date_fin, description)
VALUES (1, '2025-01-01', '2025-01-31', 'Conseillé pour la grippe saisonnière en janvier.'),
       (2, '2025-02-01', '2025-02-28', 'Produit recommandé pour les allergies au printemps.');



