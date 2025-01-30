package com.mg.app.PharmaSys.repository.produit;

import com.mg.app.PharmaSys.model.produit.Maladie.ProduitMaladie;
import com.mg.app.PharmaSys.model.produit.Maladie.ProduitMaladieId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitMaladieRepository extends JpaRepository<ProduitMaladie, ProduitMaladieId> {
    List<ProduitMaladie> findByIdIdProduit(Integer idProduit);
    List<ProduitMaladie> findByIdIdMaladie(Integer idMaladie);
    void deleteByIdIdProduit(Integer idProduit);
    void deleteByIdIdMaladie(Integer idMaladie);
}
