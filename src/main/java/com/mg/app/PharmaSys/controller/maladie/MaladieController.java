package com.mg.app.PharmaSys.controller.maladie;

import com.mg.app.PharmaSys.model.maladie.Maladie;
import com.mg.app.PharmaSys.service.maladie.MaladieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/maladie")
public class MaladieController {
    private final MaladieService MaladieService;

    @GetMapping
    public String listMaladie(Model model) {
        List<Maladie> Maladies = MaladieService.readMaladie();
        model.addAttribute("Maladies", Maladies);
        return "maladie/MaladieListe";
    }



    @GetMapping("/edit")
    public String editMaladie(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Maladie Maladie;
        if (id == null) {
            Maladie = new Maladie();
            model.addAttribute("maladie", Maladie);
            return "maladie/MaladieForm";
        }
        Maladie = MaladieService.getMaladieById(id);
        model.addAttribute("maladie", Maladie);
        return "maladie/MaladieForm";
    }

    @PostMapping("/save")
    public String saveMaladie(Maladie Maladie) {
        MaladieService.createMaladie(Maladie);
        return "redirect:/maladie";
    }

    @GetMapping("/delete")
    public String deleteMaladie(@RequestParam("id") Integer id) {
        MaladieService.deleteMaladie(id);
        return "redirect:/maladie";
    }
}

