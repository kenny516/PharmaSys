package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.HistoriquePrixProduit;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.repository.produit.HistoriquePrixProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoriquePrixProduitService {
    private HistoriquePrixProduitRepository historiquePrixRepository;
    private ProduitService produitService;

    public List<HistoriquePrixProduit> getAll() {
        return historiquePrixRepository.findAll();
    }

    public List<HistoriquePrixProduit> getByProduitId(Integer id_produit) {
        return historiquePrixRepository.findPricesBetweenDates(id_produit);
    }

    public HistoriquePrixProduit saveHistoriquePrix(HistoriquePrixProduit historiquePrixProduit) {
        return historiquePrixRepository.save(historiquePrixProduit);
    }


    public HistoriquePrixProduit getHistoriquePrixById(Integer idHistoriquePrixProduit) {
        return historiquePrixRepository.findById(idHistoriquePrixProduit).orElse(null);
    }

    public void delete(Integer idHistoriquePrixProduit) {
        historiquePrixRepository.deleteById(idHistoriquePrixProduit);
    }


    public Double getPrixCurrent(Integer idProduit, LocalDate dateVente) {
        Double prix = historiquePrixRepository.findPriceAtDate(idProduit, dateVente);
        if (prix != null) {
            System.out.println("prixxxxxxxxxxxxxxxxxxxxxx");
            return prix;
        } else {
            Produit p = produitService.getProduitById(idProduit);
            return p.getPrix();
        }
    }

}
