package com.mg.app.PharmaSys.controller.medicament;

import com.mg.app.PharmaSys.model.medicament.Laboratoire;
import com.mg.app.PharmaSys.service.medicament.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LaboratoireController {
    @Autowired
    private LaboratoireService laboratoireService;

    @GetMapping("/laboratoire")
    public String readLaboratoire(Model model) {
        List<Laboratoire> laboratoires = laboratoireService.readLaboratoire();
        model.addAttribute("laboratoires", laboratoires);
        return "medicament/LaboratoireListe";
    }

    @GetMapping("/laboratoire/edit")
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

    @PostMapping("/laboratoire/save")
    public String saveLaboratoire(Laboratoire laboratoire) {
        laboratoireService.createLaboratoire(laboratoire);
        return "redirect:/laboratoire";
    }

    @GetMapping("/laboratoire/delete")
    public String deleteLaboratoire(@RequestParam("id") Integer id) {
        laboratoireService.deleteLaboratoire(id);
        return "redirect:/laboratoire";
    }
}
