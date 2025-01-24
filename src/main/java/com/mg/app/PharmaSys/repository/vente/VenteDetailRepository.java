package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VenteDetailRepository extends JpaRepository<VenteDetail, Integer> {
    List<VenteDetail> findVenteDetailByVente(Vente idVente);

    @Query(value = "SELECT DISTINCT vd " +
            "FROM VenteDetail vd " +
            "JOIN Produit p ON vd.produit.id = p.id " +
            "JOIN Administration ad ON p.administration.id = ad.id " +
            "JOIN ProduitPublicCible ppc ON p.id = ppc.produit.id " +
            "WHERE (:idCategorie IS NULL OR p.categorie.id = :idCategorie) " +
            "AND (:idAdministration IS NULL OR ad.id = :idAdministration) " +
            "AND (:idPublicCible IS NULL OR ppc.publicCible.id = :idPublicCible)")
    List<VenteDetail> rechercheMulticritere(
            @Param("idCategorie") Integer idCategorie,
            @Param("idAdministration") Integer idAdministration,
            @Param("idPublicCible") Integer idPublicCible
    );
}
