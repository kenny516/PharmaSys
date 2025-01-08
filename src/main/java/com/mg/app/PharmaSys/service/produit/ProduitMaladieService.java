package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.Maladie.ProduitsMaladieId;
import com.mg.app.PharmaSys.model.produit.Maladie.ProduitsMaladie;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.repository.medicament.ProduitMaladieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProduitMaladieService {
    private final ProduitMaladieRepository produitMaladieRepository;

    public ProduitsMaladie createProduitMaladie(ProduitsMaladie ProduitMaladie) {
        return produitMaladieRepository.save(ProduitMaladie);
    }

    public ProduitsMaladie findById(ProduitsMaladieId id) {
        return produitMaladieRepository.findById(id).orElse(null);
    }

    public List<ProduitsMaladie> findByProduit(Produit produit) {
        return produitMaladieRepository.findByIdIdProduit(produit.getId());
    }

    public void delete(ProduitsMaladie ProduitMaladie) {
        produitMaladieRepository.delete(ProduitMaladie);
    }

    public void deleteById(ProduitsMaladieId id) {
        produitMaladieRepository.deleteById(id);
    }

}
