package com.mg.app.PharmaSys.repository.medicament;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.medicament.PublicCible;
import com.mg.app.PharmaSys.model.medicament.publicCible.MedicamentsPublicCible;
import com.mg.app.PharmaSys.model.medicament.publicCible.MedicamentsPublicCibleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentsPublicCibleRepository extends JpaRepository<MedicamentsPublicCible, MedicamentsPublicCibleId> {
    List<MedicamentsPublicCible> findByMedicament(Medicament medicament);

    // Par exemple, pour trouver tous les MedicamentsPublicCible pour un PublicCible donné
    List<MedicamentsPublicCible> findByPublicCible(PublicCible publicCible);
}
