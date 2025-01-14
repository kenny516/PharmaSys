package com.mg.app.PharmaSys.repository.produit;
import com.mg.app.PharmaSys.model.produit.ProduitConseil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProduitConseilRepository extends JpaRepository<ProduitConseil, Integer> {
    // Additional query methods if required

    @Query(value = "SELECT pc.* " +
            "FROM Produit_conseil pc " +
            "WHERE " +
            "    pc.date_debut <= :dateFin " +
            "    AND pc.date_fin >= :dateDebut", nativeQuery = true)
    List<ProduitConseil> getProduitConseil(@Param("dateDebut") LocalDate dateDebut, @Param("dateFin") LocalDate dateFin);


    @Query(value = "SELECT pc.* " +
            "FROM Produit_conseil pc " +
            "WHERE EXTRACT(YEAR FROM CAST(:date AS DATE)) >= EXTRACT(YEAR FROM pc.date_debut) " +
            "AND EXTRACT(MONTH FROM CAST(:date AS DATE)) >= EXTRACT(MONTH FROM pc.date_debut) " +
            "AND EXTRACT(YEAR FROM CAST(:date AS DATE)) <= EXTRACT(YEAR FROM pc.date_fin) " +
            "AND EXTRACT(MONTH FROM CAST(:date AS DATE)) <= EXTRACT(MONTH FROM pc.date_fin)",
            nativeQuery = true)
    List<ProduitConseil> getProduitConseil(@Param("date") LocalDate date);



}

