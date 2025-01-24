package com.mg.app.PharmaSys.controller.fournisseur;

import com.mg.app.PharmaSys.model.fournisseur.EntreeFournisseur;
import com.mg.app.PharmaSys.model.fournisseur.Fournisseur;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.service.fournisseur.EntreeFournisseurService;
import com.mg.app.PharmaSys.service.fournisseur.FournisseurService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
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
@RequestMapping("/fournisseur-entree")
public class EntreeFournisseurController {
    private final EntreeFournisseurService entreeFournisseurService;
    private final ProduitService produitService;
    private final FournisseurService fournisseurService;

    @GetMapping
    public String listEntreeFourisseur(Model model) {
        List<EntreeFournisseur> entreeFournisseurs = entreeFournisseurService.getAllEntreeFournisseur();
        model.addAttribute("entreeFournisseurs", entreeFournisseurs);
        return "fournisseur/entreeFournisseurListe";
    }

    @GetMapping("/edit")
    public String editEntreeFournisseur(@RequestParam(value = "idEntreeFournisseur" ,required = false) Integer idEntreeFournisseur, Model model) {
        EntreeFournisseur entreeFournisseur = (idEntreeFournisseur == null) ? new EntreeFournisseur() : entreeFournisseurService.getEntreeFournisseurById(idEntreeFournisseur);
        List<Produit> produits = produitService.getAllProduits();
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
        model.addAttribute("entreeFournisseur", entreeFournisseur);
        model.addAttribute("produits", produits);
        model.addAttribute("fournisseurs", fournisseurs);
        return "fournisseur/entreeFournisseurForm";
    }

    @PostMapping("/save")
    public String saveEntreeFournisseur(EntreeFournisseur entreeFournisseur,Model model) {
        Double quantiteInitial = 0.0;
        if (entreeFournisseur.getId() != null){
            EntreeFournisseur entreeFournisseur1 = entreeFournisseurService.getEntreeFournisseurById(entreeFournisseur.getId());
            quantiteInitial = entreeFournisseur1.getQuantite();
        }
        try {
            entreeFournisseurService.processEntreeFournisseur(entreeFournisseur,quantiteInitial);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error/Error";
        }
        entreeFournisseurService.createEntreeFournisseur(entreeFournisseur);
        return "redirect:/fournisseur-entree";
    }

    @GetMapping("/delete")
    public String deleteEntreeFournisseur(@RequestParam("idEntreeFournisseur") Integer idEntreeFournisseur) {
        entreeFournisseurService.deleteEntreeFournisseur(idEntreeFournisseur);
        return "redirect:/fournisseur-entree";
    }


}
