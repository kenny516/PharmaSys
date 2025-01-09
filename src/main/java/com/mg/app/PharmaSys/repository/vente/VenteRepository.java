package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Query(value = "SELECT DISTINCT v " +
            "FROM Vente v " +
            "JOIN Produit p ON v.produit.id = p.id " +
            "JOIN Administration ad ON p.administration.id = ad.id " +
            "JOIN ProduitsPublicCible ppc ON p.id = ppc.produit.id " +
            "WHERE (:idCategorie IS NULL OR p.categorie.id = :idCategorie) " +
            "AND (:idAdministration IS NULL OR ad.id = :idAdministration) " +
            "AND (:idPublicCible IS NULL OR ppc.publicCible.id = :idPublicCible)")
    List<Vente> rechercheMulticritere(
            @Param("idCategorie") Integer idCategorie,
            @Param("idAdministration") Integer idAdministration,
            @Param("idPublicCible") Integer idPublicCible
    );

}
