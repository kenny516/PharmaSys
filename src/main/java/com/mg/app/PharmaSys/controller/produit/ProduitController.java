package com.mg.app.PharmaSys.controller.produit;


import com.mg.app.PharmaSys.model.caracteristique.*;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.service.caracteristique.*;
import com.mg.app.PharmaSys.service.maladie.MaladieService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
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
    private final AdministrationService administrationService;


    @GetMapping
    public String listMedicament(Model model) {
        List<Produit> produits = ProduitService.getAllProduits();
        List<PublicCible> publicCibles = publicCibleService.getAllPublicCible();
        List<Maladie> maladies = maladieService.getAllMaladie();
        List<Categorie> categories = categorieService.getAllCategorie();
        model.addAttribute("produits", produits);

        model.addAttribute("publicCibles", publicCibles);
        model.addAttribute("maladies", maladies);
        model.addAttribute("categories", categories);

        model.addAttribute("idCategorie",null);
        model.addAttribute("idPublicCible",null);
        model.addAttribute("idMaladie",null);

        return "produit/produitListe";
    }

    @GetMapping("/edit")
    public String editMedicament(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Produit produit = (id == null) ? new Produit() : ProduitService.getProduitById(id);
        List<Laboratoire> laboratoires = laboratoireService.getAllLaboratoire();
        List<Unite> unites = uniteService.getAllUnite();
        List<Categorie> categories = categorieService.getAllCategorie();
        List<Administration> administrations = administrationService.getAllAdministration();
        model.addAttribute("produit", produit);
        model.addAttribute("laboratoires", laboratoires);
        model.addAttribute("unites",unites);
        model.addAttribute("categories",categories);
        model.addAttribute("administrations",administrations);
        return "produit/produitForm";
    }

    @PostMapping("/save")
    public String saveMedicament(Produit produit) {
        ProduitService.createProduit(produit);
        return "redirect:/produit";
    }


    @GetMapping("/delete")
    public String deleteMedicament(@RequestParam("id") Integer id) {
        ProduitService.deleteProduitById(id);
        return "redirect:/produit";
    }

    @PostMapping("/recherche")
    public String RechercheMedicament(@RequestParam(value = "maladie",required = false) Integer idMaladie,@RequestParam(value = "publicCible",required = false) Integer idPublicCible,@RequestParam(value = "categorie",required = false) Integer idCategorie,Model model) {
        List<Produit> list = ProduitService.rechercheMultiCritere(idMaladie,idPublicCible,idCategorie);
        List<PublicCible> publicCibles = publicCibleService.getAllPublicCible();
        List<Maladie> maladies = maladieService.getAllMaladie();
        List<Categorie> categories = categorieService.getAllCategorie();
        model.addAttribute("produits",list);
        model.addAttribute("publicCibles", publicCibles);
        model.addAttribute("maladies", maladies);
        model.addAttribute("categories", categories);

        model.addAttribute("idCategorie",idCategorie);
        model.addAttribute("idPublicCible",idPublicCible);
        model.addAttribute("idMaladie",idMaladie);
        return "produit/produitListe";
    }

}
