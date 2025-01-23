package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.DTO.CommissionDTO;
import com.mg.app.PharmaSys.model.caracteristique.Sexe;
import com.mg.app.PharmaSys.service.caracteristique.SexeService;
import com.mg.app.PharmaSys.service.vente.VenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/commissions")
    public String getCommissions(@RequestParam(name = "startDate",required = false) LocalDate startDate, @RequestParam(name = "endDate",required = false) LocalDate endDate, Model model,@RequestParam(name = "sexe",required = false)Integer id_sexe) {
        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().minusMonths(1);
            endDate = LocalDate.now();
        }
        List<CommissionDTO> commissions;
        if(id_sexe != null)
        {
            //commissions = venteService.getCommissionsByDateRange2Min(startDate, endDate, id_sexe);
            commissions = venteService.getCommissionsByDateRange2(startDate, endDate, id_sexe);
        }
        else {
            commissions = venteService.getCommissionsByDateRange(startDate, endDate);
        }

        List<Sexe> listeSexe = sexeService.getSexe();
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate",endDate);
        model.addAttribute("commissions",commissions);
        model.addAttribute("listeSexe",listeSexe);
        return "vente/vendeur/vendeurCommission";
    }







}
