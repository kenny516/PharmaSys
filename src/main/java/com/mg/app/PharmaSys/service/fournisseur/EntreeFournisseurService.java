package com.mg.app.PharmaSys.service.fournisseur;

import com.mg.app.PharmaSys.model.fournisseur.EntreeFournisseur;
import com.mg.app.PharmaSys.model.stock.MvtStock;
import com.mg.app.PharmaSys.model.stock.TypeMvtStock;
import com.mg.app.PharmaSys.repository.fournisseur.EntreeFournisseurRepository;
import com.mg.app.PharmaSys.service.stock.MvtStockService;
import com.mg.app.PharmaSys.service.stock.StockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class EntreeFournisseurService {
    private final EntreeFournisseurRepository entreeFournisseurRepository;
    private final MvtStockService mvtStockService;
    private final StockService stockService;

    public EntreeFournisseur createEntreeFournisseur(EntreeFournisseur entreeFournisseur) {
        return entreeFournisseurRepository.save(entreeFournisseur);
    }
    public List<EntreeFournisseur> getAllEntreeFournisseur() {
        return entreeFournisseurRepository.findAll();
    }
    public EntreeFournisseur updateEntreeFournisseur(EntreeFournisseur entreeFournisseur) {
        return entreeFournisseurRepository.save(entreeFournisseur);
    }
    public void deleteEntreeFournisseur(Integer id) {
        entreeFournisseurRepository.deleteById(id);
    }

    public EntreeFournisseur getEntreeFournisseurById(Integer id) {
        return entreeFournisseurRepository.findById(id).orElse(null);
    }


    // process entre et sortie fournisseur

    public void processEntreeFournisseur(EntreeFournisseur entreeFournisseur, Double initialQuantity) {
        double availableStock = stockService.getCurrentStockByProduitId(entreeFournisseur.getProduit().getId());

        if (entreeFournisseur.getQuantite() > initialQuantity) {
            if (availableStock < entreeFournisseur.getQuantite()) {
                throw new IllegalArgumentException("Stock insuffisant pour stock actuel"+availableStock);
            }
            TypeMvtStock movementType = new TypeMvtStock();
            movementType.setId(1); // 1 0 entree

            MvtStock mvtStock = new MvtStock();
            mvtStock.setDateMvt(entreeFournisseur.getDateEntree());
            mvtStock.setQuantite(entreeFournisseur.getQuantite());
            mvtStock.setDescription("Entree du fournisseur "+ entreeFournisseur.getFournisseur().getId());
            mvtStock.setDatePeremption(entreeFournisseur.getDatePeremption());
            mvtStock.setTypeMvt(movementType);
            mvtStock.setProduit(entreeFournisseur.getProduit());
            // creation du mvstock
            mvtStockService.createMvtStock(mvtStock);
            // creation de l entree
            createEntreeFournisseur(entreeFournisseur);
        } else if (entreeFournisseur.getId() != null) {
            processRetour(entreeFournisseur, initialQuantity);
        }
    }
    // Sous-fonction pour gérer un retour de vente (annulation)
    private void processRetour(EntreeFournisseur entreeFournisseur, Double quantiteInitial) {
        TypeMvtStock typeMvtStock = new TypeMvtStock();
        typeMvtStock.setId(2); // 1 représente le type "ENTREE"
        // Créer le mouvement de stock pour le retour
        MvtStock mvtStock = new MvtStock();
        mvtStock.setDescription("Annulation de l'entree ID: " + entreeFournisseur.getFournisseur().getId());
        mvtStock.setProduit(entreeFournisseur.getProduit());
        mvtStock.setDatePeremption(entreeFournisseur.getDatePeremption());
        mvtStock.setDateMvt(LocalDateTime.now());
        mvtStock.setTypeMvt(typeMvtStock);
        mvtStock.setQuantite(quantiteInitial - entreeFournisseur.getQuantite());

        mvtStockService.createMvtStock(mvtStock);

        createEntreeFournisseur(entreeFournisseur);

    }


}
