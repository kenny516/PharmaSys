package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.Maladie.ProduitMaladieId;
import com.mg.app.PharmaSys.model.produit.Maladie.ProduitMaladie;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.repository.produit.ProduitMaladieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProduitMaladieService {
    private final ProduitMaladieRepository produitMaladieRepository;

    public ProduitMaladie createProduitMaladie(ProduitMaladie ProduitMaladie) {
        return produitMaladieRepository.save(ProduitMaladie);
    }

    public List<ProduitMaladie> getAllProduitMaladie(){
        return produitMaladieRepository.findAll();
    }

    public ProduitMaladie getProduitMaladieById(ProduitMaladieId id) {
        return produitMaladieRepository.findById(id).orElse(null);
    }

    public List<ProduitMaladie> getProduitMaladieByProduit(Produit produit) {
        return produitMaladieRepository.findByIdIdProduit(produit.getId());
    }

    public void deleteProduitMaladie(ProduitMaladie ProduitMaladie) {
        produitMaladieRepository.delete(ProduitMaladie);
    }

    public void deleteProduitMaladieById(ProduitMaladieId id) {
        produitMaladieRepository.deleteById(id);
    }

}
