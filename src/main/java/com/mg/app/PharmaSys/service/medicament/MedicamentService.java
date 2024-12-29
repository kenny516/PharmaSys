package com.mg.app.PharmaSys.service.medicament;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.repository.medicament.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentService{

    private final MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamentService(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

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
