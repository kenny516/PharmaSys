package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Query(value = "SELECT DISTINCT v " + "FROM Vente v ")
    List<Vente> rechercheMulticritere();


    @Query(value = "SELECT DISTINCT v " + "FROM Vente v WHERE DATE(v.dateVente) = :date")
    List<Vente> rechercheClient(@Param("date") LocalDate date);


    @Query(value = """
            SELECT v.id AS vendeurId,
                   v.nom AS vendeurNom,
                   v.prenom AS vendeurPrenom,
                   SUM(ve.montant_total) AS totalVentes,
                   SUM(ve.montant_total) * 0.05 AS commission
            FROM vente ve
            JOIN vendeur v ON ve.id_vendeur = v.id
            WHERE DATE(ve.date_vente) BETWEEN :startDate AND :endDate
            GROUP BY v.id, v.nom, v.prenom
            """, nativeQuery = true)
    List<Object[]> findCommissionsByVendeurAndDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


}
