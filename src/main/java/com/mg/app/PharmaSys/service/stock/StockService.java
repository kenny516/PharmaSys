package com.mg.app.PharmaSys.service.stock;


import com.mg.app.PharmaSys.model.fournisseur.EntreeFournisseur;
import com.mg.app.PharmaSys.model.stock.MvtStock;
import com.mg.app.PharmaSys.model.stock.Stock;
import com.mg.app.PharmaSys.model.stock.TypeMvtStock;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.repository.stock.StockRepository;
import com.mg.app.PharmaSys.service.vente.VenteDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StockService {
    private final StockRepository stockRepository;
    private final MvtStockService mvtStockService;
    private final VenteDetailService venteDetailService;

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> readStock() {
        return stockRepository.findAll();
    }

    public Stock updateStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Integer id) {
        stockRepository.deleteById(id);
    }

    ///
    public Stock getStockById(Integer id) {
        return stockRepository.findById(id).orElse(null);
    }

    public Double getCurrentStockByProduitId(Integer produitId) {
        Double quantite = 0.0;
        for (Stock stock : stockRepository.findStockByProduit_IdOrderByDatePeremptionAsc(produitId)) {
            quantite += stock.getQuantiteDisponible();
        }
        return quantite;
    }

    public List<Stock> getStockDispoByIdProduit(Integer idProduit){
        return stockRepository.findStockByProduit_IdOrderByDatePeremptionAsc(idProduit);
    }


    public List<VenteDetail> processVenteDetails(VenteDetail venteDetail, Double initialQuantity) {
        double availableStock = getCurrentStockByProduitId(venteDetail.getProduit().getId());

        // Récupération des stocks disponibles triés par date de péremption
        List<Stock> availableStocks = getStockDispoByIdProduit(venteDetail.getProduit().getId());
        List<MvtStock> mvtStocks = new ArrayList<>();
        List<VenteDetail> venteDetailsGenere = new ArrayList<>();

        if (venteDetail.getQuantite() > initialQuantity) {
            if (availableStock < venteDetail.getQuantite()) {
                throw new IllegalArgumentException("Stock insuffisant pour effectuer la vente.");
            }
            // Gestion des sorties de stock (vente)
            processVente(venteDetail, availableStocks, mvtStocks, venteDetailsGenere);
        } else if (venteDetail.getId() != null) {
            // Gestion des retours en stock
            processRetourVente(venteDetail, initialQuantity, mvtStocks, venteDetailsGenere);
        }

        // Enregistrer les mouvements de stock
        for (MvtStock mvtStock : mvtStocks) {
            mvtStockService.createMvtStock(mvtStock);
        }
        return venteDetailsGenere;
    }

    // Sous-fonction pour traiter une vente
    private void processVente(VenteDetail venteDetail, List<Stock> stockCompatible, List<MvtStock> mvtStocks, List<VenteDetail> venteDetailsGenere) {
        TypeMvtStock movementType = new TypeMvtStock();
        movementType.setId(2); // 2 = Sortie de stock

        double remainingQuantity = venteDetail.getQuantite();

        for (Stock stock : stockCompatible) {
            if (remainingQuantity <= 0) break;

            // Création d'un détail de vente
            VenteDetail generatedDetail = new VenteDetail();
            generatedDetail.setVente(venteDetail.getVente());
            generatedDetail.setProduit(venteDetail.getProduit());
            generatedDetail.setPrixUnitaire(venteDetail.getPrixUnitaire());
            generatedDetail.setDatePeremption(stock.getDatePeremption());

            // Déterminer la quantité à prélever
            double usedQuantity = Math.min(remainingQuantity, stock.getQuantiteDisponible());
            generatedDetail.setQuantite(usedQuantity);
            remainingQuantity -= usedQuantity;

            // Création d'un mouvement de stock
            MvtStock stockMovement = new MvtStock();
            stockMovement.setDescription("Détail de la vente ID: " + venteDetail.getVente().getId());
            stockMovement.setProduit(venteDetail.getProduit());
            stockMovement.setDatePeremption(stock.getDatePeremption());
            stockMovement.setDateMvt(venteDetail.getVente().getDateVente());
            stockMovement.setTypeMvt(movementType);
            stockMovement.setQuantite(usedQuantity);

            // Ajouter aux listes
            mvtStocks.add(stockMovement);
            venteDetailsGenere.add(generatedDetail);
        }

        if (remainingQuantity > 0) {
            throw new IllegalArgumentException("Stock insuffisant pour satisfaire la vente.");
        }
    }
    // Sous-fonction pour gérer un retour de vente (annulation)
    private void processRetourVente(VenteDetail venteDetail, Double quantiteInitial, List<MvtStock> mvtStocks,List<VenteDetail> venteDetailsGenere) {
        TypeMvtStock typeMvtStock = new TypeMvtStock();
        typeMvtStock.setId(1); // 1 représente le type "ENTREE"
        // Créer le mouvement de stock pour le retour
        MvtStock mvtStock = new MvtStock();
        mvtStock.setDescription("Annulation de la vente ID: " + venteDetail.getVente().getId());
        mvtStock.setProduit(venteDetail.getProduit());
        mvtStock.setDatePeremption(venteDetail.getDatePeremption());
        mvtStock.setDateMvt(venteDetail.getVente().getDateVente());
        mvtStock.setTypeMvt(typeMvtStock);
        mvtStock.setQuantite(venteDetail.getQuantite());

        mvtStocks.add(mvtStock);

        if (quantiteInitial - venteDetail.getQuantite()>0) {
            venteDetailsGenere.add(venteDetail);
        }
    }



}
