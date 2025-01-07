package com.mg.app.PharmaSys.controller.produit;

import com.mg.app.PharmaSys.model.produit.Unite;
import com.mg.app.PharmaSys.service.produit.UniteService;
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
@RequestMapping("/unite")
public class UniteController {
    private final UniteService uniteService;

    @GetMapping
    public String listUnite(Model model) {
        List<Unite> unites = uniteService.readUnite();
        model.addAttribute("unites", unites);
        return "produit/UniteListe";
    }

    @GetMapping("/edit")
    public String editUnite(@RequestParam(name = "id", required = false) Integer id, Model model) {
        Unite unite = (id == null) ? new Unite() : uniteService.getUniteById(id);
        model.addAttribute("unite", unite);
        return "produit/uniteForm";
    }

    @PostMapping("/save")
    public String saveUnite(Unite unite) {
        uniteService.createUnite(unite);
        return "redirect:/unite";
    }

    @GetMapping("delete")
    public String deleteUnite(@RequestParam("id") Integer id) {
        uniteService.deleteUnite(id);
        return "redirect:/unite";
    }


}
