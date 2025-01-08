package com.mg.app.PharmaSys.controller.stock;

import com.mg.app.PharmaSys.model.stock.Stock;
import com.mg.app.PharmaSys.service.stock.StockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @GetMapping
    public String listStock(Model model) {
        List<Stock> stocks = stockService.readStock();
        model.addAttribute("stocks", stocks);
        return "stock/stockListe";
    }
}
