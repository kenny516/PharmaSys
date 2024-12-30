package com.mg.app.PharmaSys.controller.medicament;


import com.mg.app.PharmaSys.model.medicament.Laboratoire;
import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.service.medicament.LaboratoireService;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// a contructor for the entity medicament
@Controller
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;
    @Autowired
    private LaboratoireService laboratoireService;


    @GetMapping("/medicament")
    public String readMedicament(Model model) {
        List<Medicament> medicaments = medicamentService.readMedicaments();
        model.addAttribute("medicaments", medicaments);
        return "medicament/MedicamentListe";
    }

    @GetMapping("/medicament/edit")
    public String editMedicament(@RequestParam("id") Integer id, Model model) {
        Medicament medicament;
        List<Laboratoire> laboratoires = laboratoireService.readLaboratoire();
        model.addAttribute("laboratoires", laboratoires);
        if (id == null) {
            medicament = new Medicament();
            model.addAttribute("medicament", medicament);
            return "medicament/MedicamentForm";
        }
        medicament = medicamentService.getMedicamentById(id);
        model.addAttribute("medicament", medicament);
        return "medicament/MedicamentForm";
    }

    @PostMapping("/medicament/save")
    public String saveMedicament(Medicament medicament) {
        medicamentService.createMedicament(medicament);
        return "redirect:/medicament";
    }


    @GetMapping("/medicament/delete")
    public String deleteMedicament(@RequestParam("id") Integer id) {
        medicamentService.deleteMedicament(id);
        return "redirect:/medicament";
    }


}
