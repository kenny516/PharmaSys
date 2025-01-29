package com.mg.app.PharmaSys.repository.produit;

import com.mg.app.PharmaSys.model.produit.HistoriquePrixProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HistoriquePrixProduitRepository extends JpaRepository<HistoriquePrixProduit, Integer> {

    @Query(value = """
            SELECT
                *
            FROM
                historiqueprix hp
            WHERE
                hp.id_produit = :idProduit
            ORDER BY
                hp.date_changement DESC
            """, nativeQuery = true)
    List<HistoriquePrixProduit> findPricesBetweenDates(
            @Param("idProduit") Integer idProduit
    );


    @Query(value = """
            SELECT prix
            FROM historiqueprix hp
            WHERE hp.id_produit = :productId
              AND hp.date_changement <= :saleDate
            ORDER BY hp.date_changement DESC
            LIMIT 1
            """, nativeQuery = true)
    Double findPriceAtDate(@Param("productId") Integer productId, @Param("saleDate") LocalDate saleDate);
}
