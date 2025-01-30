package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.DTO.CommissionDTO;
import com.mg.app.PharmaSys.model.caracteristique.Sexe;
import com.mg.app.PharmaSys.model.vente.Vendeur;
import com.mg.app.PharmaSys.service.caracteristique.SexeService;
import com.mg.app.PharmaSys.service.vente.VendeurService;
import com.mg.app.PharmaSys.service.vente.VenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/vendeur")
public class VendeurController {
    private final VenteService venteService;
    private final SexeService sexeService;
    private final VendeurService vendeurService;

    @GetMapping("/commissions")
    public String getCommissions(@RequestParam(name = "startDate", required = false) LocalDate startDate, @RequestParam(name = "endDate", required = false) LocalDate endDate, Model model, @RequestParam(name = "sexe", required = false) Integer id_sexe) {
        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().minusMonths(1);
            endDate = LocalDate.now();
        }
        List<CommissionDTO> commissions = venteService.getCommissionVendeurByIntervalleDateAndSexe(startDate, endDate, id_sexe);
        // pour calculer le total de montant de vente
        double totalVentes = commissions.stream()
                .mapToDouble(CommissionDTO::getTotalVentes)
                .sum();
        // pour calculer le total de commission
        double totalCommissions = commissions.stream()
                .mapToDouble(CommissionDTO::getCommission)
                .sum();

        model.addAttribute("totalVentes", totalVentes);
        model.addAttribute("totalCommissions", totalCommissions);
        List<Sexe> listeSexe = sexeService.getAllSexe();

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("commissions", commissions);
        model.addAttribute("listeSexe", listeSexe);
        return "vente/vendeur/vendeurCommission";
    }

    @GetMapping()
    public String listeVendeur(Model model) {
        List<Vendeur> vendeurList =  vendeurService.getAllVendeurs();
        model.addAttribute("vendeurs", vendeurList);
        return "vente/vendeur/vendeurListe";
    }

    @GetMapping("/new")
    public String form(Model model) {
        List<Sexe> sexeList = sexeService.getAllSexe();
        model.addAttribute("sexes", sexeList);
        model.addAttribute("vendeur", new Vendeur());
        return "vente/vendeur/vendeurForm";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id") Integer id, Model model) {
        List<Sexe> sexeList = sexeService.getAllSexe();
        model.addAttribute("sexes", sexeList);
        model.addAttribute("vendeur", vendeurService.getVendeurById(id));
        return "vente/vendeur/vendeurForm";
    }

    @PostMapping("/save")
    public String save(Vendeur vendeur) {
        vendeurService.createVendeur(vendeur);
        return "redirect:/vendeur";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id")  Integer id) {
        vendeurService.deleteVendeur(id);
        return "redirect:/vendeur";
    }

}
