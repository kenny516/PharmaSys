package com.mg.app.PharmaSys.repository.stock;

import com.mg.app.PharmaSys.model.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
