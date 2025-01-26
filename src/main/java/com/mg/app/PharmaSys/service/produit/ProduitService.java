package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.repository.produit.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public Produit createProduit(Produit produit){
        return produitRepository.save(produit);
    }
    public List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }
    public Produit updateProduit(Produit produit){
        return produitRepository.save(produit);
    }
    public void deleteProduitById(Integer id){
        produitRepository.deleteById(id);
    }


    ///
    public Produit getProduitById(Integer id){
        return produitRepository.findById(id).orElse(null);
    }

     public List<Produit> rechercheMultiCritere(Integer idMaladie, Integer idPublic,Integer idCategorie) {
         return produitRepository.rechercheMultiCritere(idMaladie, idPublic,idCategorie);
     }



}
