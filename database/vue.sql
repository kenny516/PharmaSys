CREATE OR REPLACE VIEW v_stock AS
(
SELECT Max(id)  as id,
       id_produit,
       date_peremption,
       SUM(CASE
               WHEN id_type_mvt = 1 THEN quantite
               WHEN id_type_mvt = 2 THEN -quantite
               ELSE quantite
           END) AS quantite_disponible
FROM mvt_stock
GROUP BY id_produit, date_peremption
    );

