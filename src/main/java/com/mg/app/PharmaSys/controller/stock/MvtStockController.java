package com.mg.app.PharmaSys.controller.stock;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.stock.MvtStock;
import com.mg.app.PharmaSys.model.stock.TypeMvtStock;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import com.mg.app.PharmaSys.service.stock.MvtStockService;
import com.mg.app.PharmaSys.service.stock.TypeMvtStockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/mvtstock")
public class MvtStockController {

    private final MvtStockService mvtStockService;
    private final ProduitService produitService;
    private final TypeMvtStockService typeMvtStockService;

    @GetMapping
    public String listMvtStock(Model model) {
        List<MvtStock> mvtStocks = mvtStockService.readMvtStock();
        model.addAttribute("mvtStocks", mvtStocks);
        return "stock/mvtStock/mvtStockListe";
    }

    @GetMapping("/edit")
    public String editMvtStock(@RequestParam(value = "id", required = false) Integer id, Model model) {
        MvtStock mvtStock;
        List<Produit> produits = produitService.readProduits();
        List<TypeMvtStock> typesMvt = typeMvtStockService.readTypeMvtStock();

        if (id == null) {
            mvtStock = new MvtStock();
        } else {
            mvtStock = mvtStockService.getMvtStockById(id);
        }

        model.addAttribute("mvtStock", mvtStock);
        model.addAttribute("produits", produits);
        model.addAttribute("typesMvt", typesMvt);
        return "stock/mvtStock/mvtStockForm";
    }

    @PostMapping("/save")
    public String saveMvtStock(MvtStock mvtStock) {
        Produit produitMvt = produitService.getProduitById(mvtStock.getProduit().getId());
        if (!produitMvt.getPerissable()){
            mvtStock.setDatePeremption(null);
        }
        mvtStockService.createMvtStock(mvtStock);
        return "redirect:/mvtstock";
    }

    @GetMapping("/delete")
    public String deleteMvtStock(@RequestParam("id") Integer id) {
        mvtStockService.deleteMvtStock(id);
        return "redirect:/mvtstock";
    }
}