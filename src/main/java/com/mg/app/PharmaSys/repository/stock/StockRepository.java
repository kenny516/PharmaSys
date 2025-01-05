package com.mg.app.PharmaSys.repository.stock;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findStockByMedicament_IdOrderByDatePeremptionAsc(Integer medicamentId);

    @Query(value = "SELECT * FROM Stock WHERE id_medicament = :idMedicament AND date_peremption = :datePeremption", nativeQuery = true)
    Stock findStockByMedicamentAndDatePeremption(@Param("idMedicament") Integer idMedicament, @Param("datePeremption") LocalDate datePeremption);




}
