package com.mg.app.PharmaSys.service.medicament;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.repository.medicament.MedicamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicamentService{

    private final MedicamentRepository medicamentRepository;

    public Medicament createMedicament(Medicament medicament){
        return medicamentRepository.save(medicament);
    }
    public List<Medicament> readMedicaments(){
        return medicamentRepository.findAll();
    }
    public Medicament updateMedicament(Medicament medicament){
        return medicamentRepository.save(medicament);
    }
    public void deleteMedicament(Integer id){
        medicamentRepository.deleteById(id);
    }


    ///
    public Medicament getMedicamentById(Integer id){
        return medicamentRepository.findById(id).orElse(null);
    }



}
