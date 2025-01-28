package com.mg.app.PharmaSys.controller.produit;

import com.mg.app.PharmaSys.model.produit.HistoriquePrix;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.service.produit.HistoriquePrixService;
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
@RequestMapping("/historiquePrix")
public class HistoriquePrixController {
    private HistoriquePrixService historiquePrixService;
    private ProduitService produitService;

    @GetMapping
    public String getHistorique(Model model)
    {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits",produits);
        List<HistoriquePrix> historiquePrix = historiquePrixService.getAll();
        model.addAttribute("historiques",historiquePrix);
        return "produit/historiquePrix/historiquePrixListe";
    }
    @GetMapping("/new")
    public String formulaire(Model model)
    {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits",produits);
        model.addAttribute("historique",new HistoriquePrix());
        return "produit/historiquePrix/historiquePrixFrom";
    }

    @GetMapping("/recherche")
    public String rechercher(@RequestParam(name = "idProduit") Integer idProduit, Model model){
        List<HistoriquePrix> historiquePrixList = historiquePrixService.getByProduitId(idProduit);
        model.addAttribute("historiques",historiquePrixList);
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits",produits);
        return "produit/historiquePrix/historiquePrixListe";
    }

    @PostMapping("/save")
    public String formulair(HistoriquePrix historiquePrix)
    {
        historiquePrixService.saveHistoriquePrix(historiquePrix);
        return "redirect:/historiquePrix";
    }



}
