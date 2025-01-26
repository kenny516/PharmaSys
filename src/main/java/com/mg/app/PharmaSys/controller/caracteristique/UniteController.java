package com.mg.app.PharmaSys.controller.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Unite;
import com.mg.app.PharmaSys.service.caracteristique.UniteService;
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
@RequestMapping("/caracteristique/unite")
public class UniteController {
    private final UniteService uniteService;

    @GetMapping
    public String listUnite(Model model) {
        List<Unite> unites = uniteService.getAllUnite();
        model.addAttribute("unites", unites);
        return "caracteristique/unite/uniteListe";
    }

    @GetMapping("/edit")
    public String editUnite(@RequestParam(name = "id", required = false) Integer id, Model model) {
        Unite unite = (id == null) ? new Unite() : uniteService.getUniteById(id);
        model.addAttribute("unite", unite);
        return "caracteristique/unite/uniteForm";
    }

    @PostMapping("/save")
    public String saveUnite(Unite unite) {
        uniteService.createUnite(unite);
        return "redirect:/caracteristique/unite";
    }

    @GetMapping("delete")
    public String deleteUnite(@RequestParam("id") Integer id) {
        uniteService.deleteUnite(id);
        return "redirect:/caracteristique/unite";
    }


}
