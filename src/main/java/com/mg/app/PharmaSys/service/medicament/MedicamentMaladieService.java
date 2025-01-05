package com.mg.app.PharmaSys.service.medicament;

import com.mg.app.PharmaSys.model.medicament.Maladie.MedicamentMaladieId;
import com.mg.app.PharmaSys.model.medicament.Maladie.MedicamentsMaladie;
import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.repository.medicament.MedicamentMaladieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicamentMaladieService {
    private final MedicamentMaladieRepository medicamentMaladieRepository;

    public MedicamentsMaladie CreateMedicamentsMaladie(MedicamentsMaladie medicamentsMaladie) {
        return medicamentMaladieRepository.save(medicamentsMaladie);
    }

    public MedicamentsMaladie findById(MedicamentMaladieId id) {
        return medicamentMaladieRepository.findById(id).orElse(null);
    }

    public List<MedicamentsMaladie> findByMedicament(Medicament medicament) {
        return medicamentMaladieRepository.findByIdIdMedicament(medicament.getId());
    }

    public void delete(MedicamentsMaladie medicamentsMaladie) {
        medicamentMaladieRepository.delete(medicamentsMaladie);
    }

    public void deleteById(MedicamentMaladieId id) {
        medicamentMaladieRepository.deleteById(id);
    }

}
