package com.mg.app.PharmaSys.repository.medicament;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {

    @Query(value = "SELECT DISTINCT m.id, m.nom, m.description, m.prix,m.id_laboratoire " +
            "FROM Medicament m " +
            "         JOIN Medicaments_maladie mm ON m.id = mm.id_medicament " +
            "         JOIN Medicaments_Public_cible mp ON m.id = mp.id_medicament " +
            "WHERE mm.id_maladie = :idMaladie " +
            "  AND mp.id_public = :idPublic ",nativeQuery = true)
    List<Medicament> rechercheMultiCritere(@Param("idMaladie") Integer idMaladie, @Param("idPublic") Integer idPublic);
}