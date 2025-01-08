package com.mg.app.PharmaSys.controller.produit;


import com.mg.app.PharmaSys.model.caracteristique.Maladie;
import com.mg.app.PharmaSys.model.caracteristique.Laboratoire;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import com.mg.app.PharmaSys.model.caracteristique.Unite;
import com.mg.app.PharmaSys.service.maladie.MaladieService;
import com.mg.app.PharmaSys.service.caracteristique.LaboratoireService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import com.mg.app.PharmaSys.service.caracteristique.PublicCibleService;
import com.mg.app.PharmaSys.service.caracteristique.CategorieService;
import com.mg.app.PharmaSys.service.caracteristique.UniteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// a contructor for the entity produit
@AllArgsConstructor
@Controller
@RequestMapping("/produit")
public class ProduitController {
    private final ProduitService ProduitService;
    private final LaboratoireService laboratoireService;
    private final UniteService uniteService;
    private final CategorieService categorieService;
    private final PublicCibleService publicCibleService;
    private final MaladieService maladieService;


    @GetMapping
    public String listMedicament(Model model) {
        List<Produit> produits = ProduitService.readProduits();
        List<PublicCible> publicCibles = publicCibleService.readPublicCible();
        List<Maladie> maladies = maladieService.readMaladie();
        List<Categorie> categories = categorieService.readCategorie();
        model.addAttribute("produits", produits);
        model.addAttribute("publicCibles", publicCibles);
        model.addAttribute("maladies", maladies);
        model.addAttribute("categories", categories);
        return "produit/produitListe";
    }

    @GetMapping("/edit")
    public String editMedicament(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Produit produit = (id == null) ? new Produit() : ProduitService.getProduitById(id);
        List<Laboratoire> laboratoires = laboratoireService.readLaboratoire();
        List<Unite> unites = uniteService.readUnite();
        List<Categorie> categories = categorieService.readCategorie();
        model.addAttribute("produit", produit);
        model.addAttribute("laboratoires", laboratoires);
        model.addAttribute("unites",unites);
        model.addAttribute("categories",categories);
        return "produit/produitForm";
    }

    @PostMapping("/save")
    public String saveMedicament(Produit produit) {
        ProduitService.createProduit(produit);
        return "redirect:/produit";
    }


    @GetMapping("/delete")
    public String deleteMedicament(@RequestParam("id") Integer id) {
        ProduitService.deleteProduit(id);
        return "redirect:/produit";
    }

    @PostMapping("/recherche")
    public String RechercheMedicament(@RequestParam("maladie") Integer idMaladie,@RequestParam("publicCible") Integer idPublicCible,@RequestParam("categorie") Integer idCategorie,Model model) {
        List<Produit> list = ProduitService.rechercheMultiCritere(idMaladie,idPublicCible,idCategorie);
        List<PublicCible> publicCibles = publicCibleService.readPublicCible();
        List<Maladie> maladies = maladieService.readMaladie();
        List<Categorie> categories = categorieService.readCategorie();
        model.addAttribute("produits",list);
        model.addAttribute("publicCibles", publicCibles);
        model.addAttribute("maladies", maladies);
        model.addAttribute("categories", categories);
        return "produit/produitListe";
    }

}
