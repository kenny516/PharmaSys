package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Query(value = "SELECT distinct v.*" +
            "FROM Vente v\n" +
            "         JOIN Produit p ON v.id_produit = p.id" +
            "         JOIN administration ad ON p.id_administration = ad.id" +
            "         JOIN Produit_public_cible ppc ON p.id = ppc.id_produit " +
            "WHERE p.id_categorie = :id_categorie" +
            "  AND p.id_administration =:id_administration" +
            "  AND ppc.id_public = :id_publicCible",nativeQuery = true)
    public List<Vente> rechercheMulticritere(Integer id_categorie, Integer id_administration, Integer id_publicCible);
}
