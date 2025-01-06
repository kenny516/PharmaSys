package com.mg.app.PharmaSys.service.medicament;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.medicament.PublicCible;
import com.mg.app.PharmaSys.model.medicament.publicCible.MedicamentsPublicCible;
import com.mg.app.PharmaSys.model.medicament.publicCible.MedicamentsPublicCibleId;
import com.mg.app.PharmaSys.repository.medicament.MedicamentsPublicCibleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicamentsPublicCibleService {
    private final MedicamentsPublicCibleRepository medicamentsPublicCibleRepository;


    public MedicamentsPublicCible CreateMedicamentsPublicCible(MedicamentsPublicCible medicamentsPublicCible) {
        return medicamentsPublicCibleRepository.save(medicamentsPublicCible);
    }

    public MedicamentsPublicCible findById(MedicamentsPublicCibleId id) {
        return medicamentsPublicCibleRepository.findById(id).orElse(null);
    }

    public List<MedicamentsPublicCible> reMedicamentsPublicCibles() {
        return medicamentsPublicCibleRepository.findAll();
    }

    public List<MedicamentsPublicCible> findByMedicament(Medicament medicament) {
        return medicamentsPublicCibleRepository.findByMedicament(medicament);
    }

    public List<MedicamentsPublicCible> findByPublicCible(PublicCible publicCible) {
        return medicamentsPublicCibleRepository.findByPublicCible(publicCible);
    }

    public void deleteById(MedicamentsPublicCibleId id) {
        medicamentsPublicCibleRepository.deleteById(id);
    }

    public void delete(MedicamentsPublicCible medicamentsPublicCible) {
        medicamentsPublicCibleRepository.delete(medicamentsPublicCible);
    }
}
