package com.mg.app.PharmaSys.controller.produit;

import com.mg.app.PharmaSys.model.produit.HistoriquePrixProduit;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.service.produit.HistoriquePrixProduitService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/historiquePrixProduits")
public class HistoriquePrixProduitController {
    private HistoriquePrixProduitService historiquePrixProduitService;
    private ProduitService produitService;

    @GetMapping
    public String getHistorique(@RequestParam(name = "idProduit", required = false) Integer idProduit, Model model) {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits", produits);
        List<HistoriquePrixProduit> historiquePrixProduits = historiquePrixProduitService.getAll();
        if (idProduit != null) {
            historiquePrixProduits = historiquePrixProduitService.getByProduitId(idProduit);
        }
        model.addAttribute("historiques", historiquePrixProduits);
        return "produit/historiquePrix/historiquePrixProduitListe";
    }

    @GetMapping("/new")
    public String formulaire(Model model) {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits", produits);
        model.addAttribute("historique", new HistoriquePrixProduit());
        return "produit/historiquePrix/historiquePrixProduitFrom";
    }
    @GetMapping("/edit")
    public String formulaireEdit(@RequestParam(name = "idHistoriquePrixProduit")Integer idHistoriquePrixProduit,Model model) {
        List<Produit> produits = produitService.getAllProduits();
        HistoriquePrixProduit historiquePrixProduit = historiquePrixProduitService.getHistoriquePrixById(idHistoriquePrixProduit);
        model.addAttribute("produits", produits);
        model.addAttribute("historique", historiquePrixProduit);
        return "produit/historiquePrix/historiquePrixProduitFrom";
    }

    @PostMapping("/save")
    public String formulair(HistoriquePrixProduit historiquePrixProduit) {
        historiquePrixProduitService.saveHistoriquePrix(historiquePrixProduit);
        return "redirect:/historiquePrixProduits";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "idHistoriquePrixProduit") Integer idHistoriquePrixProduit) {
        historiquePrixProduitService.delete(idHistoriquePrixProduit);
        return "redirect:/historiquePrixProduits";
    }

}
