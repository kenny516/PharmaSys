package com.mg.app.PharmaSys.repository.stock;

import com.mg.app.PharmaSys.model.stock.MvtStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStockRepository extends JpaRepository<MvtStock, Integer> {
}