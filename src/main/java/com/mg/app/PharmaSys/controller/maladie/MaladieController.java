package com.mg.app.PharmaSys.controller.Maladie;

import com.mg.app.PharmaSys.model.maladie.Maladie;
import com.mg.app.PharmaSys.service.maladie.MaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Maladie")
public class MaladieController {
    @Autowired
    private MaladieService MaladieService;

    @GetMapping
    public String listMaladie(Model model) {
        List<Maladie> Maladies = MaladieService.readMaladie();
        model.addAttribute("Maladies", Maladies);
        return "Maladie/MaladieListe";
    }

    @GetMapping("/edit")
    public String editMaladie(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Maladie Maladie;
        if (id == null) {
            Maladie = new Maladie();
            model.addAttribute("Maladie", Maladie);
            return "Maladie/MaladieForm";
        }
        Maladie = MaladieService.getMaladieById(id);
        model.addAttribute("Maladie", Maladie);
        return "Maladie/MaladieForm";
    }

    @PostMapping("/save")
    public String saveMaladie(Maladie Maladie) {
        MaladieService.createMaladie(Maladie);
        return "redirect:/Maladie";
    }

    @GetMapping("/delete")
    public String deleteMaladie(@RequestParam("id") Integer id) {
        MaladieService.deleteMaladie(id);
        return "redirect:/Maladie";
    }
}

