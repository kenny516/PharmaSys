package com.mg.app.PharmaSys.controller.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitPublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitPublicCibleId;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import com.mg.app.PharmaSys.service.produit.ProduitPublicCibleService;
import com.mg.app.PharmaSys.service.caracteristique.PublicCibleService;
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
@RequestMapping("/produit-public-cible")
public class ProduitPublicCibleController {
    private final ProduitPublicCibleService produitPublicCibleService;
    private final PublicCibleService publicCibleService;
    private final ProduitService produitService;

    @GetMapping
    public String listProduitPublicCible(@RequestParam(name = "idProduit")Integer idProduit, Model model) {
        Produit produit = new Produit();
        produit.setId(idProduit);
        List<ProduitPublicCible> produitPublicCibles = produitPublicCibleService.getProduitPublicCibleByProduit(produit);
        model.addAttribute("produitPublicCible", produitPublicCibles);
        model.addAttribute("idProduit", idProduit);
        return "produit/publicCible/produitPublicCIbleListe";
    }

    @GetMapping("/edit")
    public String editProduitPublicCible(@RequestParam(value = "idProduit") Integer idProduit, @RequestParam(value = "idPublicCible",required = false) Integer idPublicCible, Model model) {
        ProduitPublicCible produitPublicCible;
        List<PublicCible> publicCibles = publicCibleService.getAllPublicCible();
        model.addAttribute("publicCibles", publicCibles);
        if (idPublicCible == null) {
            Produit produit = produitService.getProduitById(idProduit);
            produitPublicCible = new ProduitPublicCible();
            produitPublicCible.setProduit(produit);

            model.addAttribute("produitPublicCible", produitPublicCible);
            return "produit/publicCible/produitPublicCibleForm";
        }
        ProduitPublicCibleId id = new ProduitPublicCibleId(idProduit, idPublicCible);
        produitPublicCible = produitPublicCibleService.getProduitPublicCibleById(id);
        model.addAttribute("produitPublicCible", produitPublicCible);
        return "produit/publicCible/produitPublicCibleForm";
    }

    @PostMapping("/save")
    public String saveProduitPublicCible(ProduitPublicCible produitPublicCible) {
        ProduitPublicCibleId id = new ProduitPublicCibleId(produitPublicCible.getProduit().getId(), produitPublicCible.getPublicCible().getId());
        produitPublicCible.setId(id);
        produitPublicCibleService.createProduitPublicCible(produitPublicCible);
        return "redirect:/produit-public-cible?idProduit="+ produitPublicCible.getProduit().getId();
    }

    @GetMapping("/delete")
    public String deleteProduitPublicCible(@RequestParam("idProduit") Integer idProduit, @RequestParam("idPublicCible") Integer idPublicCible) {
        ProduitPublicCibleId id = new ProduitPublicCibleId(idProduit, idPublicCible);
        produitPublicCibleService.deleteProduitPublicCibleById(id);
        return "redirect:/produit-public-cible?idProduit="+ idProduit;
    }



}
