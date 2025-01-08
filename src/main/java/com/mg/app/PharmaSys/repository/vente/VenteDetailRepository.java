package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VenteDetailRepository extends JpaRepository<VenteDetail, Integer> {
    List<VenteDetail> findVenteDetailByVente(Vente idVente);
}
