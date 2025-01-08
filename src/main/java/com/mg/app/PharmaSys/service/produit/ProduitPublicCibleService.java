package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitsPublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitsPublicCibleId;
import com.mg.app.PharmaSys.repository.medicament.ProduitPublicCibleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitPublicCibleService {
    private final ProduitPublicCibleRepository produitPublicCibleRepository;


    public ProduitsPublicCible createProduitPublicCible(ProduitsPublicCible produitsPublicCible) {
        return produitPublicCibleRepository.save(produitsPublicCible);
    }

    public ProduitsPublicCible findById(ProduitsPublicCibleId id) {
        return produitPublicCibleRepository.findById(id).orElse(null);
    }

    public List<ProduitsPublicCible> readProduitPublicCibles() {
        return produitPublicCibleRepository.findAll();
    }

    public List<ProduitsPublicCible> findByProduit(Produit produit) {
        return produitPublicCibleRepository.findByProduit(produit);
    }

    public List<ProduitsPublicCible> findByPublicCible(PublicCible publicCible) {
        return produitPublicCibleRepository.findByPublicCible(publicCible);
    }

    public void deleteById(ProduitsPublicCibleId id) {
        produitPublicCibleRepository.deleteById(id);
    }

    public void delete(ProduitsPublicCible produitsPublicCible) {
        produitPublicCibleRepository.delete(produitsPublicCible);
    }
}
