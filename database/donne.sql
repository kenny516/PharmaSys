-- Insertion des laboratoires
INSERT INTO Laboratoire (nom, telephone, adresse)
VALUES ('PharmaLab', '0123456789', '123 Rue de la Santé'),
       ('MediCorp', '0987654321', '456 Avenue des Médicaments');

-- Insertion des maladies
INSERT INTO Maladie (nom, description)
VALUES ('Grippe', 'Maladie virale causant fièvre et toux'),
       ('Diabète', 'Trouble métabolique causant une glycémie élevée');

-- Insertion des ventes
INSERT INTO Vente (date_vente, montant_total)
VALUES ('2025-01-05 10:00:00', 150.50),
       ('2025-01-06 11:30:00', 200.00);

-- Insertion des publics cibles
INSERT INTO Public_cible (categorie)
VALUES ('Adultes'),
       ('Enfants');

-- Insertion des types de mouvements de stock
INSERT INTO Type_mvt_stock (nom, description)
VALUES ('Entrée', 'Ajout de médicaments au stock'),
       ('Sortie', 'Retrait de médicaments du stock');

-- Insertion des rôles
INSERT INTO Role (nom, description)
VALUES ('Administrateur', 'Gère le système'),
       ('Pharmacien', 'Gère les médicaments et les ventes');

-- Insertion des fournisseurs
INSERT INTO Fournisseur (nom, contact)
VALUES ('Fournisseur A', 'contact@fournisseura.com'),
       ('Fournisseur B', 'contact@fournisseurb.com');

-- Insertion des médicaments
INSERT INTO Medicament (nom, description, prix, id_laboratoire)
VALUES ('Doliprane', 'Médicament contre la douleur et la fièvre', 5.50, 1),
       ('Insuline', 'Traitement du diabète', 20.00, 2);

-- Insertion des détails des ventes
INSERT INTO Vente_detail (quantite, date_peremption, prix_unitaire, id_medicament, id_vente)
VALUES (2, '2026-01-05', 5.50, 1, 1),
       (1, '2026-06-15', 20.00, 2, 2);

-- Insertion dans le stock
INSERT INTO Stock (quantite_disponible, date_dernier_mouvement, date_peremption, id_medicament)
VALUES (100, '2025-01-05 09:00:00', '2026-01-05', 1),
       (50, '2025-01-06 10:00:00', '2026-06-15', 2);

-- Insertion des mouvements de stock
INSERT INTO MvtStock (date_mvt, quantite, description, date_peremption, id_type_mvt, id_medicament)
VALUES ('2025-01-05 08:30:00', 100, 'Stock initial', '2026-01-05', 1, 1),
       ('2025-01-06 09:45:00', 50, 'Stock initial', '2026-06-15', 1, 2);

-- Insertion des utilisateurs
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, id_role)
VALUES ('Dupont', 'Jean', 'jean.dupont@example.com', 'password123', 1),
       ('Martin', 'Marie', 'marie.martin@example.com', 'securepass', 2);

-- Insertion des entrées fournisseur
INSERT INTO Entree_fournisseur (quantite, date_peremption, id_medicament, id_fournisseur)
VALUES (50, '2026-01-05', 1, 1),
       (30, '2026-06-15', 2, 2);

-- Insertion des relations médicament-maladie
INSERT INTO Medicaments_maladie (id_medicament, id_maladie)
VALUES (1, 1),
       (2, 2);

-- Insertion des relations médicament-public cible
INSERT INTO Medicaments_Public_cible (id_medicament, id_public)
VALUES (1, 1),
       (2, 2);
