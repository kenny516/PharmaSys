package com.mg.app.PharmaSys.controller.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitsPublicCible;
import com.mg.app.PharmaSys.model.produit.publicCible.ProduitsPublicCibleId;
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
        List<ProduitsPublicCible> produitsPublicCibles = produitPublicCibleService.findByProduit(produit);
        model.addAttribute("produitPublicCible", produitsPublicCibles);
        model.addAttribute("idProduit", idProduit);
        return "produit/publicCible/produitPublicCIbleListe";
    }

    @GetMapping("/edit")
    public String editProduitPublicCible(@RequestParam(value = "idProduit") Integer idProduit, @RequestParam(value = "idPublicCible",required = false) Integer idPublicCible, Model model) {
        ProduitsPublicCible produitsPublicCible;
        List<PublicCible> publicCibles = publicCibleService.readPublicCible();
        model.addAttribute("publicCibles", publicCibles);
        if (idPublicCible == null) {
            Produit produit = produitService.getProduitById(idProduit);
            produitsPublicCible = new ProduitsPublicCible();
            produitsPublicCible.setProduit(produit);

            model.addAttribute("produitPublicCible", produitsPublicCible);
            return "produit/publicCible/produitPublicCibleForm";
        }
        ProduitsPublicCibleId id = new ProduitsPublicCibleId(idProduit, idPublicCible);
        produitsPublicCible = produitPublicCibleService.findById(id);
        model.addAttribute("produitPublicCible", produitsPublicCible);
        return "produit/publicCible/produitPublicCibleForm";
    }

    @PostMapping("/save")
    public String saveProduitPublicCible(ProduitsPublicCible produitsPublicCible) {
        ProduitsPublicCibleId id = new ProduitsPublicCibleId(produitsPublicCible.getProduit().getId(), produitsPublicCible.getPublicCible().getId());
        produitsPublicCible.setId(id);
        produitPublicCibleService.createProduitPublicCible(produitsPublicCible);
        return "redirect:/produit-public-cible?idProduit="+ produitsPublicCible.getProduit().getId();
    }

    @GetMapping("/delete")
    public String deleteProduitPublicCible(@RequestParam("idProduit") Integer idProduit, @RequestParam("idPublicCible") Integer idPublicCible) {
        ProduitsPublicCibleId id = new ProduitsPublicCibleId(idProduit, idPublicCible);
        produitPublicCibleService.deleteById(id);
        return "redirect:/produit-public-cible?idProduit="+ idProduit;
    }



}
