package com.mg.app.PharmaSys.controller.fournisseur;

import com.mg.app.PharmaSys.model.fournisseur.Fournisseur;
import com.mg.app.PharmaSys.service.fournisseur.FournisseurService;
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
@RequestMapping("/fournisseur")
public class FournisseurController {
    private final FournisseurService fournisseurService;

    @GetMapping
    public String listFournisseur(Model model) {
        List<Fournisseur> fournisseurs = fournisseurService.readFournisseurs();
        model.addAttribute("fournisseurs", fournisseurs);
        return "fournisseur/fournisseurListe";
    }

    @GetMapping("/edit")
    public String editFournisseur(@RequestParam(value = "idFournisseur",required = false) Integer idFournisseur, Model model) {
        Fournisseur fournisseur = (idFournisseur == null) ? new Fournisseur() : fournisseurService.getFournisseurById(idFournisseur);
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/fournisseurForm";
    }

    @PostMapping("/save")
    public String saveFournisseur(Fournisseur fournisseur) {
        fournisseurService.createFournisseur(fournisseur);
        return "redirect:/fournisseur";
    }

    @GetMapping("/delete")
    public String deleteFournisseur(@RequestParam("idFournisseur") Integer idFournisseur) {
        fournisseurService.deleteFournisseur(idFournisseur);
        return "redirect:/fournisseur";
    }
}
