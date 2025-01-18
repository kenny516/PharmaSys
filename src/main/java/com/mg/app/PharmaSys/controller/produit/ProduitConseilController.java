package com.mg.app.PharmaSys.controller.produit;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.produit.ProduitConseil;
import com.mg.app.PharmaSys.service.produit.ProduitConseilService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/produi-conseils")
public class ProduitConseilController {

    private final ProduitConseilService produitConseilService;
    private final ProduitService produitService;

    @GetMapping
    public String getAllProduitConseils(Model model) {
        List<ProduitConseil> produitConseils = produitConseilService.rechercheF22();
        model.addAttribute("date",LocalDate.now());
        model.addAttribute("produitConseils", produitConseils);
        return "produit/produitConseil/produitConseilListe";
    }

    @PostMapping
    public ResponseEntity<ProduitConseil> createProduitConseil(@RequestBody ProduitConseil produitConseil) {
        return ResponseEntity.ok(produitConseilService.saveProduitConseil(produitConseil));
    }

    @GetMapping("/edit")
    public String formInsert(@RequestParam(value = "id",required = false) Integer id,Model model) {
        ProduitConseil produitConseils = new ProduitConseil();
        if (id!=null){
            produitConseils = produitConseilService.getProduitConseilById(id);
        }
        List<Produit> produits = produitService.readProduits();
        model.addAttribute("produits",produits);
        model.addAttribute("produitConseils",produitConseils);
        return "produit/produitConseil/produitConseilForm";
    }

    @PostMapping("recherche")
    public String recherche(@RequestParam(value = "mois")Integer mois,@RequestParam(value = "annee")Integer annee, Model model){
        LocalDate date = LocalDate.of(annee,mois,1);

        model.addAttribute("date",date);

        List<ProduitConseil> produitConseils = produitConseilService.rechercheF(date);
        model.addAttribute("produitConseils", produitConseils);
        return "produit/produitConseil/produitConseilListe";
    }

    @PostMapping("/save")
    public String saveConseil(ProduitConseil produitConseil){
        produitConseilService.saveProduitConseil(produitConseil);
        return "redirect:/produi-conseils";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        produitConseilService.deleteProduitConseilById(id);
        return "redirect:/produi-conseils";
    }

}
