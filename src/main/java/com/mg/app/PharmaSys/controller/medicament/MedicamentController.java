package com.mg.app.PharmaSys.controller.medicament;


import com.mg.app.PharmaSys.model.maladie.Maladie;
import com.mg.app.PharmaSys.model.medicament.Laboratoire;
import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.medicament.PublicCible;
import com.mg.app.PharmaSys.service.maladie.MaladieService;
import com.mg.app.PharmaSys.service.medicament.LaboratoireService;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
import com.mg.app.PharmaSys.service.medicament.PublicCibleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// a contructor for the entity medicament
@AllArgsConstructor
@Controller
@RequestMapping("/medicament")
public class MedicamentController {
    private final MedicamentService medicamentService;
    private final LaboratoireService laboratoireService;
    private final PublicCibleService publicCibleService;
    private final MaladieService maladieService;


    @GetMapping
    public String listMedicament(Model model) {
        List<Medicament> medicaments = medicamentService.readMedicaments();
        model.addAttribute("medicaments", medicaments);
        return "medicament/MedicamentListe";
    }

    @GetMapping("/edit")
    public String editMedicament(@RequestParam(value = "id",required = false) Integer id, Model model) {
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

    @PostMapping("/save")
    public String saveMedicament(Medicament medicament) {
        medicamentService.createMedicament(medicament);
        return "redirect:/medicament";
    }


    @GetMapping("/delete")
    public String deleteMedicament(@RequestParam("id") Integer id) {
        medicamentService.deleteMedicament(id);
        return "redirect:/medicament";
    }

    @GetMapping("/rechercheForm")
    public String RechercheMedicamentPage(Model model) {
        List<PublicCible> publicCibles = publicCibleService.readPublicCible();
        List<Maladie> maladies = maladieService.readMaladie();
        model.addAttribute("publicCibles", publicCibles);
        model.addAttribute("maladies", maladies);
        return "medicament/Recherche/RechercheForm";
    }
    @PostMapping("/recherche")
    public String RechercheMedicament(@RequestParam("maladie") Integer idMaladie,@RequestParam("publicCible") Integer idPublicCible,Model model) {
        List<Medicament> list = medicamentService.rechercheMultiCritere(idMaladie,idPublicCible);
        model.addAttribute("medicaments",list);
        return "medicament/MedicamentListe";
    }

}
