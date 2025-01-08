package com.mg.app.PharmaSys.repository.medicament;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitsPublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitsPublicCibleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitPublicCibleRepository extends JpaRepository<ProduitsPublicCible, ProduitsPublicCibleId> {
    List<ProduitsPublicCible> findByProduit(Produit produit);

    // Par exemple, pour trouver tous les ProduitsPublicCible pour un PublicCible donné
    List<ProduitsPublicCible> findByPublicCible(PublicCible publicCible);
}
