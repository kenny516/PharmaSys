-- Ajouter de nouveaux produits
INSERT INTO Produit (nom, description, prix, perissable,id_administration, id_unite, id_categorie, id_laboratoire)
VALUES
    ('Ibuprofène', 'Anti-inflammatoire non stéroïdien.', 5.0, FALSE, 1,1, 2, 1),
    ('Azithromycine', 'Antibiotique à large spectre.', 12.0, TRUE, 1,2, 1, 2),
    ('Vitamine C', 'Complément alimentaire pour renforcer le système immunitaire.', 3.0, FALSE, 1,1, 2, 1),
    ('Oméprazole', 'Inhibiteur de la pompe à protons pour traiter les ulcères.', 7.5, FALSE, 1,1, 1, 2);


-- Ajouter des conseils pour les nouveaux produits
INSERT INTO Produit_conseil (id_produit, date_debut, date_fin, description)
VALUES
    (1, '2025-03-01', '2025-03-31', 'Recommandé pour les douleurs articulaires durant le printemps.'),
    (4, '2025-04-01', '2025-04-30', 'Idéal pour prévenir les infections respiratoires en avril.'),
    (5, '2025-05-01', '2025-05-31', 'Recommandé pour renforcer l’immunité avant l’été.'),
    (6, '2025-06-01', '2025-06-30', 'Utilisé pour soulager les symptômes de reflux gastrique en été.');


