package com.mg.app.PharmaSys.controller.medicament;

import com.mg.app.PharmaSys.model.Maladies.Maladies;
import com.mg.app.PharmaSys.model.medicament.Maladie.MedicamentMaladieId;
import com.mg.app.PharmaSys.model.medicament.Maladie.MedicamentsMaladie;
import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.service.Maladies.MaladiesService;
import com.mg.app.PharmaSys.service.medicament.MedicamentMaladieService;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
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
@RequestMapping("/medicament-maladie")
public class MedicamentMaladieController {
    private final MedicamentMaladieService medicamentMaladieService;
    private final MaladiesService maladieService;
    private final MedicamentService medicamentService;


    @GetMapping
    public String listMedicamentMaladie(@RequestParam(name = "idMedicament")Integer idMedicament, Model model) {
        Medicament medicament = new Medicament();
        medicament.setId(idMedicament);
        List<MedicamentsMaladie> medicamentsMaladies = medicamentMaladieService.findByMedicament(medicament);
        model.addAttribute("medicamentsMaladies", medicamentsMaladies);
        model.addAttribute("idMedicament", idMedicament);
        return "medicament/maladie/MedicamentsMaladieListe";
    }

    @GetMapping("/edit")
    public String editMedicamentMaladie(@RequestParam(value = "idMedicament") Integer idMedicament, @RequestParam(value = "idMaladie",required = false) Integer idMaladie, Model model) {
        MedicamentsMaladie medicamentsMaladie;
        List<Maladies> maladies = maladieService.readMaladies();
        model.addAttribute("maladies", maladies);
        if (idMaladie == null) {
            Medicament medicament = medicamentService.getMedicamentById(idMedicament);
            medicamentsMaladie = new MedicamentsMaladie();
            medicamentsMaladie.setMedicament(medicament);

            model.addAttribute("medicamentsMaladie", medicamentsMaladie);
            return "medicament/maladie/MedicamentsMaladieForm";
        }
        MedicamentMaladieId id = new MedicamentMaladieId(idMedicament, idMaladie);
        medicamentsMaladie = medicamentMaladieService.findById(id);
        model.addAttribute("medicamentsMaladie", medicamentsMaladie);
        return "medicament/maladie/MedicamentsMaladieForm";
    }

    @PostMapping("/save")
    public String saveMedicamentMaladie(MedicamentsMaladie medicamentsMaladie) {
        MedicamentMaladieId id = new MedicamentMaladieId(medicamentsMaladie.getMedicament().getId(), medicamentsMaladie.getMaladie().getId());
        medicamentsMaladie.setId(id);
        medicamentMaladieService.CreateMedicamentsMaladie(medicamentsMaladie);
        return "redirect:/medicament-maladie?idMedicament=" + medicamentsMaladie.getMedicament().getId();
    }

    @GetMapping("/delete")
    public String deleteMedicamentMaladie(@RequestParam(value = "idMedicament") Integer idMedicament, @RequestParam(value = "idMaladie") Integer idMaladie) {
        MedicamentMaladieId id = new MedicamentMaladieId(idMedicament, idMaladie);
        medicamentMaladieService.deleteById(id);
        return "redirect:/medicament-maladie?idMedicament=" + idMedicament;
    }



}
