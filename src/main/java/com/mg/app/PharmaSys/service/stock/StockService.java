package com.mg.app.PharmaSys.service.stock;

import com.mg.app.PharmaSys.model.stock.Stock;
import com.mg.app.PharmaSys.repository.stock.MvtStockRepository;
import com.mg.app.PharmaSys.repository.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;
    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(Stock stock){
        return stockRepository.save(stock);
    }
    public List<Stock> readStock(){
        return stockRepository.findAll();
    }
    public Stock updateStock(Stock stock){
        return stockRepository.save(stock);
    }
    public void deleteStock(Integer id){
        stockRepository.deleteById(id);
    }

    ///
    public Stock getStockById(Integer id){
        return stockRepository.findById(id).orElse(null);
    }

}
