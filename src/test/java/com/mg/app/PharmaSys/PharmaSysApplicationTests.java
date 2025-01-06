package com.mg.app.PharmaSys;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.stock.MvtStock;
import com.mg.app.PharmaSys.model.stock.Stock;
import com.mg.app.PharmaSys.model.stock.TypeMvtStock;
import com.mg.app.PharmaSys.model.utilisateur.Role;
import com.mg.app.PharmaSys.service.stock.StockService;
import com.mg.app.PharmaSys.service.utilisateur.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PharmaSysApplicationTests {
	@Autowired
	StockService stockService;

	@Test
	void contextLoads() {
		Medicament medicament = new Medicament();
		medicament.setId(1);
		TypeMvtStock typeMvtStock = new TypeMvtStock();
		typeMvtStock.setId(2);
		typeMvtStock.setNom("Sortie");
		MvtStock mvt = new MvtStock();
		mvt.setQuantite(1000.0);
		mvt.setDescription("balablbla");
		mvt.setDatePeremption(LocalDate.parse("2025-12-31"));
		mvt.setMedicament(medicament);
		mvt.setTypeMvt(typeMvtStock);
		mvt.setDateMvt(LocalDateTime.now());
		//Stock stock =stockService.updateStockByMvtStock(mvt);
		//System.out.println(stock);
	}

}
