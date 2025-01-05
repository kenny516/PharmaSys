package com.mg.app.PharmaSys.controller.medicament;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.medicament.PublicCible;
import com.mg.app.PharmaSys.model.medicament.publicCible.MedicamentsPublicCible;
import com.mg.app.PharmaSys.model.medicament.publicCible.MedicamentsPublicCibleId;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
import com.mg.app.PharmaSys.service.medicament.MedicamentsPublicCibleService;
import com.mg.app.PharmaSys.service.medicament.PublicCibleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/medicament-public-cible")
public class MedicamentPublicCibleController {
    private final MedicamentsPublicCibleService medicamentsPublicCibleService;
    private final PublicCibleService publicCibleService;
    private final MedicamentService medicamentService;

    @GetMapping
    public String listMedicamentPublicCible(@RequestParam(name = "idMedicament")Integer idMedicament, Model model) {
        Medicament medicament = new Medicament();
        medicament.setId(idMedicament);
        List<MedicamentsPublicCible> medicamentsPublicCibles = medicamentsPublicCibleService.findByMedicament(medicament);
        model.addAttribute("medicamentsPublicCibles", medicamentsPublicCibles);
        model.addAttribute("idMedicament", idMedicament);
        return "medicament/publicCible/MedicamentsPublicCIbleListe";
    }

    @GetMapping("/edit")
    public String editMedicamentPublicCible(@RequestParam(value = "idMedicament") Integer idMedicament, @RequestParam(value = "idPublicCible",required = false) Integer idPublicCible, Model model) {
        MedicamentsPublicCible medicamentsPublicCible;
        List<PublicCible> publicCibles = publicCibleService.readPublicCible();
        model.addAttribute("publicCibles", publicCibles);
        if (idPublicCible == null) {
            Medicament medicament = medicamentService.getMedicamentById(idMedicament);
            medicamentsPublicCible = new MedicamentsPublicCible();
            medicamentsPublicCible.setMedicament(medicament);

            model.addAttribute("medicamentsPublicCible", medicamentsPublicCible);
            return "medicament/publicCible/MedicamentsPublicCibleForm";
        }
        MedicamentsPublicCibleId id = new MedicamentsPublicCibleId(idMedicament, idPublicCible);
        medicamentsPublicCible = medicamentsPublicCibleService.findById(id);
        model.addAttribute("medicamentsPublicCible", medicamentsPublicCible);
        return "medicament/publicCible/MedicamentsPublicCibleForm";
    }

    @PostMapping("/save")
    public String saveMedicamentPublicCible(MedicamentsPublicCible medicamentsPublicCible) {
        MedicamentsPublicCibleId id = new MedicamentsPublicCibleId(medicamentsPublicCible.getMedicament().getId(), medicamentsPublicCible.getPublicCible().getId());
        medicamentsPublicCible.setId(id);
        medicamentsPublicCibleService.CreMedicamentsPublicCible(medicamentsPublicCible);
        return "redirect:/medicament-public-cible?idMedicament="+medicamentsPublicCible.getMedicament().getId();
    }

    @GetMapping("/delete")
    public String deleteMedicamentPublicCible(@RequestParam("idMedicament") Integer idMedicament, @RequestParam("idPublicCible") Integer idPublicCible) {
        MedicamentsPublicCibleId id = new MedicamentsPublicCibleId(idMedicament, idPublicCible);
        medicamentsPublicCibleService.deleteById(id);
        return "redirect:/medicament-public-cible?idMedicament="+idMedicament;
    }



}
