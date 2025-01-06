package com.mg.app.PharmaSys.controller.stock;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.stock.Stock;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
import com.mg.app.PharmaSys.service.stock.StockService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;
    private final MedicamentService medicamentService;

    @GetMapping
    public String listStock(Model model) {
        List<Stock> stocks = stockService.readStock();
        model.addAttribute("stocks", stocks);
        return "stock/StockListe";
    }
}
