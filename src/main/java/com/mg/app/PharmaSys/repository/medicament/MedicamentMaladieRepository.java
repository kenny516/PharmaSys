package com.mg.app.PharmaSys.repository.medicament;

import com.mg.app.PharmaSys.model.medicament.Maladie.MedicamentMaladieId;
import com.mg.app.PharmaSys.model.medicament.Maladie.MedicamentsMaladie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentMaladieRepository extends JpaRepository<MedicamentsMaladie, MedicamentMaladieId> {
    List<MedicamentsMaladie> findByIdIdMedicament(Integer idMedicament);
    List<MedicamentsMaladie> findByIdIdMaladie(Integer idMaladie);
    void deleteByIdIdMedicament(Integer idMedicament);
    void deleteByIdIdMaladie(Integer idMaladie);
}
