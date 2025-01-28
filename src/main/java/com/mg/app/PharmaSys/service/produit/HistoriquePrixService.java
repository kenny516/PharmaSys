package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.HistoriquePrix;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.repository.produit.HistoriquePrixRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoriquePrixService {
    private HistoriquePrixRepository historiquePrixRepository;
    private ProduitService produitService;

    public List<HistoriquePrix> getAll ()
    {
        return historiquePrixRepository.findAll();
    }

    public List<HistoriquePrix> getByProduitId (Integer id_produit)
    {
        return historiquePrixRepository.findPricesBetweenDates(id_produit);
    }

    public HistoriquePrix saveHistoriquePrix(HistoriquePrix historiquePrix)
    {
        return historiquePrixRepository.save(historiquePrix);
    }

    public Double getPrixCurrent(Integer idProduit, LocalDate dateVente){
        Double prix = historiquePrixRepository.findPriceAtDate(idProduit,dateVente);
        if (prix != null){
            System.out.println("prixxxxxxxxxxxxxxxxxxxxxx");
            return prix;
        }
        else {
            Produit p = produitService.getProduitById(idProduit);
            return p.getPrix();
        }
    }

}
