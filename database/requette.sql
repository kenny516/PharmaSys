SELECT distinct v.*
FROM vente_detail v
         JOIN Produit p ON v.id_produit = p.id
         JOIN administration ad ON p.id_administration = ad.id
         JOIN Produit_public_cible ppc ON p.id = ppc.id_produit
WHERE p.id_categorie = 1
  AND p.id_administration = 1
  AND ppc.id_public = 1;
