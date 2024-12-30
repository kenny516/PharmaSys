package com.mg.app.PharmaSys.controller.stock;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.stock.Stock;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
import com.mg.app.PharmaSys.service.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private MedicamentService medicamentService;

    @GetMapping("/stock")
    public String readStock(Model model) {
        List<Stock> stocks = stockService.readStock();
        model.addAttribute("stocks", stocks);
        return "stock/StockListe";
    }

    @GetMapping("/stock/edit")
    public String editStock(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Stock stock;
        List<Medicament> medicaments = medicamentService.readMedicaments();
        if (id == null) {
            stock = new Stock();
        } else {
            stock = stockService.getStockById(id);
        }
        model.addAttribute("stock", stock);
        model.addAttribute("medicaments", medicaments);
        return "stock/StockForm";
    }

    @PostMapping("/stock/save")
    public String saveStock(Stock stock) {
        System.out.println(stock.getDatePeremption());
        System.out.println(stock.getDateDernierMouvement());
        //stockService.createStock(stock);
        return "redirect:/stock";
    }

    @GetMapping("/stock/delete")
    public String deleteStock(@RequestParam("id") Integer id) {
        stockService.deleteStock(id);
        return "redirect:/stock";
    }
}
