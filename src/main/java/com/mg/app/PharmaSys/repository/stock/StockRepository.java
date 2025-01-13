package com.mg.app.PharmaSys.repository.stock;

import com.mg.app.PharmaSys.model.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findStockByProduit_IdOrderByDatePeremptionAsc(Integer idProduit);

    @Query(value = "SELECT * FROM v_stock WHERE id_produit = :idProduit AND date_peremption = :datePeremption", nativeQuery = true)
    Stock findStockByMedicamentAndDatePeremption(@Param("idProduit") Integer idProduit, @Param("datePeremption") LocalDate datePeremption);

    Integer id(Integer id);
}
