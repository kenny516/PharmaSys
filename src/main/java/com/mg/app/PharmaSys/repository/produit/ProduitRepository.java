package com.mg.app.PharmaSys.repository.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    @Query(value = "SELECT DISTINCT m.id, m.nom, m.description, m.prix,m.id_laboratoire " +
            "FROM produit m " +
            "         JOIN produits_maladie mm ON m.id = mm.id_produit " +
            "         JOIN produits_public_cible mp ON m.id = mp.id_produit " +
            "WHERE mm.id_maladie = :idMaladie " +
            "  AND mp.id_public = :idPublic " +
            "  AND m.id_categorie = :idCategorie",nativeQuery = true)
    List<Produit> rechercheMultiCritere(@Param("idMaladie") Integer idMaladie, @Param("idPublic") Integer idPublic,@Param("idCategorie") Integer idCategorie);
}