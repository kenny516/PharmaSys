package com.mg.app.PharmaSys.controller.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Maladie;
import com.mg.app.PharmaSys.service.maladie.MaladieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/caracteristique/maladie")
public class MaladieController {
    private final MaladieService maladieService;

    @GetMapping
    public String listMaladie(Model model) {
        List<Maladie> Maladies = maladieService.readMaladie();
        model.addAttribute("Maladies", Maladies);
        return "caracteristique/maladie/maladieListe";
    }



    @GetMapping("/edit")
    public String editMaladie(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Maladie Maladie;
        if (id == null) {
            Maladie = new Maladie();
            model.addAttribute("maladie", Maladie);
            return "caracteristique/maladie/maladieForm";
        }
        Maladie = maladieService.getMaladieById(id);
        model.addAttribute("maladie", Maladie);
        return "caracteristique/maladie/maladieForm";
    }

    @PostMapping("/save")
    public String saveMaladie(Maladie Maladie) {
        maladieService.createMaladie(Maladie);
        return "redirect:/caracteristique/maladie";
    }

    @GetMapping("/delete")
    public String deleteMaladie(@RequestParam("id") Integer id) {
        maladieService.deleteMaladie(id);
        return "redirect:/caracteristique/maladie";
    }
}

