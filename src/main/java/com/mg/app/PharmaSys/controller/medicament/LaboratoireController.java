package com.mg.app.PharmaSys.controller.medicament;

import com.mg.app.PharmaSys.model.medicament.Laboratoire;
import com.mg.app.PharmaSys.service.medicament.LaboratoireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/laboratoire")
public class LaboratoireController {
    private final LaboratoireService laboratoireService;

    @GetMapping
    public String listLaboratoire(Model model) {
        List<Laboratoire> laboratoires = laboratoireService.readLaboratoire();
        model.addAttribute("laboratoires", laboratoires);
        return "medicament/LaboratoireListe";
    }

    @GetMapping("/edit")
    public String editLaboratoire(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Laboratoire laboratoire;
        if (id == null) {
            laboratoire = new Laboratoire();
            model.addAttribute("laboratoire", laboratoire);
            return "medicament/LaboratoireForm";
        }
        laboratoire = laboratoireService.getLaboratoireById(id);
        model.addAttribute("laboratoire", laboratoire);
        return "medicament/LaboratoireForm";
    }

    @PostMapping("/save")
    public String saveLaboratoire(Laboratoire laboratoire) {
        laboratoireService.createLaboratoire(laboratoire);
        return "redirect:/laboratoire";
    }

    @GetMapping("/delete")
    public String deleteLaboratoire(@RequestParam("id") Integer id) {
        laboratoireService.deleteLaboratoire(id);
        return "redirect:/laboratoire";
    }
}
