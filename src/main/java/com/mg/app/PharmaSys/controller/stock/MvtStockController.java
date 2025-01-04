package com.mg.app.PharmaSys.controller.stock;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.stock.MvtStock;
import com.mg.app.PharmaSys.model.stock.TypeMvtStock;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
import com.mg.app.PharmaSys.service.stock.MvtStockService;
import com.mg.app.PharmaSys.service.stock.TypeMvtStockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/mvtstock")
public class MvtStockController {

    private final MvtStockService mvtStockService;
    private final MedicamentService medicamentService;
    private final TypeMvtStockService typeMvtStockService;

    @GetMapping
    public String listMvtStock(Model model) {
        List<MvtStock> mouvements = mvtStockService.readMvtStock();
        model.addAttribute("mouvements", mouvements);
        return "stock/MvtStockListe";
    }

    @GetMapping("/edit")
    public String editMvtStock(@RequestParam(value = "id", required = false) Integer id, Model model) {
        MvtStock mvtStock;
        List<Medicament> medicaments = medicamentService.readMedicaments();
        List<TypeMvtStock> typesMvt = typeMvtStockService.readTypeMvtStock();

        if (id == null) {
            mvtStock = new MvtStock();
        } else {
            mvtStock = mvtStockService.getMvtStockById(id);
        }

        model.addAttribute("mvtStock", mvtStock);
        model.addAttribute("medicaments", medicaments);
        model.addAttribute("typesMvt", typesMvt);
        return "stock/MvtStockForm";
    }

    @PostMapping("/save")
    public String saveMvtStock(MvtStock mvtStock) {
        mvtStockService.createMvtStock(mvtStock);
        return "redirect:/mvtstock";
    }

    @GetMapping("/delete")
    public String deleteMvtStock(@RequestParam("id") Integer id) {
        mvtStockService.deleteMvtStock(id);
        return "redirect:/mvtstock";
    }
}