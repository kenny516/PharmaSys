package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.DTO.CommissionDTO;
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

    @GetMapping("/commissions")
    public String getCommissions(@RequestParam(name = "startDate",required = false) LocalDate startDate, @RequestParam(name = "endDate",required = false) LocalDate endDate, Model model) {
        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().minusMonths(1);
            endDate = LocalDate.now();
        }
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate",endDate);
        List<CommissionDTO> commissions = venteService.getCommissionsByDateRange(startDate, endDate);
        model.addAttribute("commissions",commissions);
        return "vente/vendeur/vendeurCommission";
    }




}
