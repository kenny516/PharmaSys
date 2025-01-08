package com.mg.app.PharmaSys.controller.produit;

import com.mg.app.PharmaSys.model.caracteristique.Maladie;
import com.mg.app.PharmaSys.model.produit.Maladie.ProduitsMaladieId;
import com.mg.app.PharmaSys.model.produit.Maladie.ProduitsMaladie;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.service.maladie.MaladieService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import com.mg.app.PharmaSys.service.produit.ProduitMaladieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/produit-maladie")
public class ProduitMaladieController {
    private final ProduitMaladieService produitMaladieService;
    private final MaladieService maladieService;
    private final ProduitService produitService;


    @GetMapping
    public String listProduitMaladie(@RequestParam(name = "idProduit")Integer idProduit, Model model) {
        Produit produit = new Produit();
        produit.setId(idProduit);
        List<ProduitsMaladie> produitsMaladies = produitMaladieService.findByProduit(produit);
        model.addAttribute("produitsMaladies", produitsMaladies);
        model.addAttribute("idProduit", idProduit);
        return "produit/maladie/produitMaladieListe";
    }

    @GetMapping("/edit")
    public String editProduitMaladie(@RequestParam(value = "idProduit") Integer idProduit, @RequestParam(value = "idMaladie",required = false) Integer idMaladie, Model model) {
        ProduitsMaladie produitsMaladie;
        List<Maladie> maladies = maladieService.readMaladie();
        model.addAttribute("maladies", maladies);
        if (idMaladie == null) {
            Produit produit = produitService.getProduitById(idProduit);
            produitsMaladie = new ProduitsMaladie();
            produitsMaladie.setProduit(produit);

            model.addAttribute("produitMaladie", produitsMaladie);
            return "produit/maladie/produitMaladieForm";
        }
        ProduitsMaladieId id = new ProduitsMaladieId(idProduit, idMaladie);
        produitsMaladie = produitMaladieService.findById(id);
        model.addAttribute("produitMaladie", produitsMaladie);
        return "produit/maladie/produitMaladieForm";
    }

    @PostMapping("/save")
    public String saveProduitMaladie(ProduitsMaladie ProduitMaladie) {
        ProduitsMaladieId id = new ProduitsMaladieId(ProduitMaladie.getProduit().getId(), ProduitMaladie.getMaladie().getId());
        ProduitMaladie.setId(id);
        produitMaladieService.createProduitMaladie(ProduitMaladie);
        return "redirect:/produit-maladie?idProduit=" + ProduitMaladie.getProduit().getId();
    }

    @GetMapping("/delete")
    public String deleteProduitMaladie(@RequestParam(value = "idProduit") Integer idProduit, @RequestParam(value = "idMaladie") Integer idMaladie) {
        ProduitsMaladieId id = new ProduitsMaladieId(idProduit, idMaladie);
        produitMaladieService.deleteById(id);
        return "redirect:/produit-maladie?idProduit=" + idProduit;
    }



}
