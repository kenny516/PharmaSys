package com.mg.app.PharmaSys.controller.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.service.caracteristique.PublicCibleService;
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
@RequestMapping("/caracteristique/public-cible")
public class PublicCibleController {
    private final PublicCibleService publicCibleService;

    @GetMapping
    public String listPublicCible(Model model) {
        List<PublicCible> publicCibles = publicCibleService.readPublicCible();
        model.addAttribute("publicCibles", publicCibles);
        return "caracteristique/publicCIble/publicCibleListe";
    }

    @GetMapping("/edit")
    public String editPublicCible(@RequestParam(value = "id",required = false) Integer id, Model model) {
        PublicCible publicCible;
        if (id == null) {
            publicCible = new PublicCible();
            model.addAttribute("publicCible", publicCible);
            return "caracteristique/publicCIble/publicCibleForm";
        }
        publicCible = publicCibleService.getPublicCibleById(id);
        model.addAttribute("publicCible", publicCible);
        return "caracteristique/publicCIble/publicCibleForm";
    }

    @PostMapping("/save")
    public String savePublicCible(PublicCible publicCible) {
        publicCibleService.createPublicCible(publicCible);
        return "redirect:/caracteristique/public-cible";
    }

    @GetMapping("/delete")
    public String deletePublicCible(@RequestParam("id") Integer id) {
        publicCibleService.deletePublicCible(id);
        return "redirect:/caracteristique/public-cible";
    }



}
