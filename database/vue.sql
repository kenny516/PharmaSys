CREATE OR REPLACE VIEW v_stock AS
(
SELECT Max(id)  as id,
       id_medicament,
       date_peremption,
       SUM(CASE
               WHEN id_type_mvt = 1 THEN quantite
               WHEN id_type_mvt = 2 THEN -quantite
               ELSE 0
           END) AS quantite_disponible
FROM mvtstock
GROUP BY id_medicament, date_peremption
    );

