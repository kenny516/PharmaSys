package com.mg.app.PharmaSys.controller.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import com.mg.app.PharmaSys.service.caracteristique.CategorieService;
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
@RequestMapping("/caracteristique/categorie")
public class CategorieController {

    private final CategorieService categorieService;

    @GetMapping
    public String listCategories(Model model) {
        List<Categorie> categories = categorieService.getAllCategorie();
        model.addAttribute("categories", categories);
        return "caracteristique/categorie/categorieListe";
    }

    @GetMapping("/edit")
    public String editCategorie(@RequestParam(name = "id", required = false) Integer id, Model model) {
        Categorie categorie = (id == null) ? new Categorie() : categorieService.getCategorieById(id);
        model.addAttribute("categorie", categorie);
        return "caracteristique/categorie/categorieForm";
    }

    @PostMapping("/save")
    public String saveCategorie(Categorie categorie) {
        categorieService.createCategorie(categorie);
        return "redirect:/caracteristique/categorie";
    }

    @GetMapping("/delete")
    public String deleteCategorie(@RequestParam("id") Integer id) {
        categorieService.deleteCategorie(id);
        return "redirect:/caracteristique/categorie";
    }
}
