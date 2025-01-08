package com.mg.app.PharmaSys.repository.produit;

import com.mg.app.PharmaSys.model.produit.Maladie.ProduitsMaladieId;
import com.mg.app.PharmaSys.model.produit.Maladie.ProduitsMaladie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitMaladieRepository extends JpaRepository<ProduitsMaladie, ProduitsMaladieId> {
    List<ProduitsMaladie> findByIdIdProduit(Integer idProduit);
    List<ProduitsMaladie> findByIdIdMaladie(Integer idMaladie);
    void deleteByIdIdProduit(Integer idProduit);
    void deleteByIdIdMaladie(Integer idMaladie);
}
