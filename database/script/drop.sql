-- Désactive les contraintes FK temporairement (optionnel, CASCADE gère déjà les dépendances)
SET session_replication_role = replica;

-- Supprime toutes les tables avec CASCADE pour gérer les dépendances
DROP TABLE IF EXISTS Produit_public_cible CASCADE;
DROP TABLE IF EXISTS Produit_maladie CASCADE;
DROP TABLE IF EXISTS Vente_detail CASCADE;
DROP TABLE IF EXISTS Vente CASCADE;
DROP TABLE IF EXISTS Vendeur CASCADE;
DROP TABLE IF EXISTS Produit_conseil CASCADE;
DROP TABLE IF EXISTS Entree_fournisseur CASCADE;
DROP TABLE IF EXISTS Utilisateur CASCADE;
DROP TABLE IF EXISTS Mvt_stock CASCADE;
DROP TABLE IF EXISTS Produit CASCADE;
DROP TABLE IF EXISTS Parametre CASCADE;
DROP TABLE IF EXISTS Sexe CASCADE;
DROP TABLE IF EXISTS Client CASCADE;
DROP TABLE IF EXISTS Administration CASCADE;
DROP TABLE IF EXISTS Categorie CASCADE;
DROP TABLE IF EXISTS Unite CASCADE;
DROP TABLE IF EXISTS Fournisseur CASCADE;
DROP TABLE IF EXISTS Role CASCADE;
DROP TABLE IF EXISTS Type_mvt_stock CASCADE;
DROP TABLE IF EXISTS Public_cible CASCADE;
DROP TABLE IF EXISTS Maladie CASCADE;
DROP TABLE IF EXISTS Laboratoire CASCADE;

-- Réactive les contraintes
SET session_replication_role = DEFAULT;