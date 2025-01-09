package com.mg.app.PharmaSys.repository.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    @Query(value = "SELECT DISTINCT m " +
            "FROM Produit m " +
            "         JOIN ProduitsMaladie mm ON m.id = mm.produit.id " +
            "         JOIN ProduitsPublicCible mp ON m.id = mp.produit.id " +
            "WHERE (:idMaladie is null or mm.maladie.id = :idMaladie) " +
            "  AND (:idPublic is null or mp.publicCible.id = :idPublic) " +
            "  AND (:idCategorie is null or m.categorie.id = :idCategorie)")
    List<Produit> rechercheMultiCritere(@Param("idMaladie") Integer idMaladie, @Param("idPublic") Integer idPublic,@Param("idCategorie") Integer idCategorie);
}