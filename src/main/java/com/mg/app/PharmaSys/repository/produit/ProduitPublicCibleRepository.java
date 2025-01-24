package com.mg.app.PharmaSys.repository.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitPublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitPublicCibleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitPublicCibleRepository extends JpaRepository<ProduitPublicCible, ProduitPublicCibleId> {
    List<ProduitPublicCible> findByProduit(Produit produit);

    // Par exemple, pour trouver tous les ProduitPublicCible pour un PublicCible donné
    List<ProduitPublicCible> findByPublicCible(PublicCible publicCible);
}
