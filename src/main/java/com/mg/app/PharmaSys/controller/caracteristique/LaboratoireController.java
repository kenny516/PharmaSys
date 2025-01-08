package com.mg.app.PharmaSys.controller.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Laboratoire;
import com.mg.app.PharmaSys.service.caracteristique.LaboratoireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/caracteristique/laboratoire")
public class LaboratoireController {
    private final LaboratoireService laboratoireService;

    @GetMapping
    public String listLaboratoire(Model model) {
        List<Laboratoire> laboratoires = laboratoireService.readLaboratoire();
        model.addAttribute("laboratoires", laboratoires);
        return "caracteristique/laboratoire/laboratoireListe";
    }

    @GetMapping("/edit")
    public String editLaboratoire(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Laboratoire laboratoire;
        if (id == null) {
            laboratoire = new Laboratoire();
            model.addAttribute("laboratoire", laboratoire);
            return "caracteristique/laboratoire/laboratoireForm";
        }
        laboratoire = laboratoireService.getLaboratoireById(id);
        model.addAttribute("laboratoire", laboratoire);
        return "caracteristique/laboratoire/laboratoireForm";
    }

    @PostMapping("/save")
    public String saveLaboratoire(Laboratoire laboratoire) {
        laboratoireService.createLaboratoire(laboratoire);
        return "redirect:/caracteristique/laboratoire";
    }

    @GetMapping("/delete")
    public String deleteLaboratoire(@RequestParam("id") Integer id) {
        laboratoireService.deleteLaboratoire(id);
        return "redirect:/caracteristique/laboratoire";
    }
}
