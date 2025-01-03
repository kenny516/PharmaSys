package com.mg.app.PharmaSys.controller.Maladies;

import com.mg.app.PharmaSys.model.Maladies.Maladies;
import com.mg.app.PharmaSys.service.Maladies.MaladiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Maladies")
public class MaladiesController {
    @Autowired
    private MaladiesService MaladiesService;

    @GetMapping
    public String listMaladies(Model model) {
        List<Maladies> Maladiess = MaladiesService.readMaladies();
        model.addAttribute("Maladiess", Maladiess);
        return "Maladies/MaladiesListe";
    }

    @GetMapping("/edit")
    public String editMaladies(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Maladies Maladies;
        if (id == null) {
            Maladies = new Maladies();
            model.addAttribute("Maladies", Maladies);
            return "Maladies/MaladiesForm";
        }
        Maladies = MaladiesService.getMaladiesById(id);
        model.addAttribute("Maladies", Maladies);
        return "Maladies/MaladiesForm";
    }

    @PostMapping("/save")
    public String saveMaladies(Maladies Maladies) {
        MaladiesService.createMaladies(Maladies);
        return "redirect:/Maladies";
    }

    @GetMapping("/delete")
    public String deleteMaladies(@RequestParam("id") Integer id) {
        MaladiesService.deleteMaladies(id);
        return "redirect:/Maladies";
    }
}

