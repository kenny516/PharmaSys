package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitPublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitPublicCibleId;
import com.mg.app.PharmaSys.repository.produit.ProduitPublicCibleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitPublicCibleService {
    private final ProduitPublicCibleRepository produitPublicCibleRepository;


    public ProduitPublicCible createProduitPublicCible(ProduitPublicCible produitPublicCible) {
        return produitPublicCibleRepository.save(produitPublicCible);
    }

    public ProduitPublicCible getProduitPublicCibleById(ProduitPublicCibleId id) {
        return produitPublicCibleRepository.findById(id).orElse(null);
    }

    public List<ProduitPublicCible> getAllProduitPublicCibles() {
        return produitPublicCibleRepository.findAll();
    }

    public List<ProduitPublicCible> getProduitPublicCibleByProduit(Produit produit) {
        return produitPublicCibleRepository.findByProduit(produit);
    }

    public List<ProduitPublicCible> getProduitPublicCibleByPublicCible(PublicCible publicCible) {
        return produitPublicCibleRepository.findByPublicCible(publicCible);
    }

    public void deleteProduitPublicCibleById(ProduitPublicCibleId id) {
        produitPublicCibleRepository.deleteById(id);
    }

    public void deleteProduitPublicCible(ProduitPublicCible produitPublicCible) {
        produitPublicCibleRepository.delete(produitPublicCible);
    }
}
