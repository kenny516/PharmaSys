package com.mg.app.PharmaSys.service.stock;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.stock.MvtStock;
import com.mg.app.PharmaSys.model.stock.Stock;
import com.mg.app.PharmaSys.model.stock.TypeMvtStock;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.repository.stock.MvtStockRepository;
import com.mg.app.PharmaSys.repository.stock.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class StockService {
    private final StockRepository stockRepository;
    private final MvtStockService mvtStockService;

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

    public Double getCurrentStockByMedicamentId(Integer medicamentId) {
        Double quantite = 0.0;
        for (Stock stock : stockRepository.findStockByMedicament_IdOrderByDatePeremptionAsc(medicamentId)) {
            quantite += stock.getQuantiteDisponible();
        }
        return quantite;
    }
// a voir pour la gestion de retour en stock
    public List<MvtStock> updateStockForSale(VenteDetail venteDetail) {
        if (getCurrentStockByMedicamentId(venteDetail.getMedicament().getId()) < venteDetail.getQuantite()){
            throw new IllegalArgumentException("Stock insuffisant pour effectuer la vente.");
        }
        List<Stock> stockCompatible = stockRepository.findStockByMedicament_IdOrderByDatePeremptionAsc(venteDetail.getMedicament().getId());
        List<MvtStock> mvtStocks = new ArrayList<>();
        TypeMvtStock typeMvtStock = new TypeMvtStock();
        if (venteDetail.getQuantite()>0){
            typeMvtStock.setId(2);
            typeMvtStock.setNom("Sortie");
        }else {
            typeMvtStock.setId(1);
            typeMvtStock.setNom("Entree");
        }
        for (Stock stock : stockCompatible) {
            MvtStock mvtStock = new MvtStock();
            mvtStock.setDescription("ventedetail for vente id: " + venteDetail.getVente().getId());
            mvtStock.setMedicament(venteDetail.getMedicament());
            mvtStock.setDatePeremption(stock.getDatePeremption());
            mvtStock.setDateMvt(venteDetail.getVente().getDateVente());
            mvtStock.setTypeMvt(typeMvtStock);
            mvtStocks.add(mvtStock);
            if (stock.getQuantiteDisponible() >= venteDetail.getQuantite()){
                mvtStock.setQuantite(venteDetail.getQuantite());
                break;
            }else {
                mvtStock.setQuantite(stock.getQuantiteDisponible());
                venteDetail.setQuantite(venteDetail.getQuantite() - stock.getQuantiteDisponible());
            }
            if (venteDetail.getQuantite() == 0){
                break;
            }
        }
        for (MvtStock mvtStock : mvtStocks) {
            updateStockByMvtStock(mvtStock);
            mvtStockService.createMvtStock(mvtStock);
        }
        return mvtStocks;
    }

    public Stock updateStockByMvtStock(MvtStock mvtStock) {
        Stock stockCorrespondant = stockRepository.findStockByMedicamentAndDatePeremption(mvtStock.getMedicament().getId(), mvtStock.getDatePeremption());
        String typeMvt = mvtStock.getTypeMvt().getNom();
        double mvtQuantity = mvtStock.getQuantite();

        if (stockCorrespondant != null) {
            if ("Sortie".equals(typeMvt)) {
                if (stockCorrespondant.getQuantiteDisponible() >= mvtQuantity) {
                    stockCorrespondant.setQuantiteDisponible(
                            stockCorrespondant.getQuantiteDisponible() - mvtQuantity
                    );
                    stockCorrespondant.setDateDernierMouvement(mvtStock.getDateMvt());
                    return updateStock(stockCorrespondant);
                } else {
                    throw new IllegalArgumentException("Stock insuffisant pour effectuer une sortie.");
                }
            } else if ("Entree".equals(typeMvt)) {
                stockCorrespondant.setQuantiteDisponible(
                        stockCorrespondant.getQuantiteDisponible() + mvtQuantity
                );
                stockCorrespondant.setDateDernierMouvement(mvtStock.getDateMvt());
                return updateStock(stockCorrespondant);
            }
        } else if ("Entree".equals(typeMvt)) {
            Stock newStock = new Stock();
            newStock.setMedicament(mvtStock.getMedicament());
            newStock.setQuantiteDisponible(mvtQuantity);
            newStock.setDatePeremption(mvtStock.getDatePeremption());
            newStock.setDateDernierMouvement(mvtStock.getDateMvt());
            return createStock(newStock);
        }
        return null;
    }


}
