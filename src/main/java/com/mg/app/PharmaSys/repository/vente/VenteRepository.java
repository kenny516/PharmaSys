package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Query(value = "SELECT DISTINCT v " +
            "FROM Vente v ")
    List<Vente> rechercheMulticritere();

}
