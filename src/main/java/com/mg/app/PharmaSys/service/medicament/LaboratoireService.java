package com.mg.app.PharmaSys.service.medicament;

import com.mg.app.PharmaSys.model.medicament.Laboratoire;
import com.mg.app.PharmaSys.repository.medicament.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoireService {
    private final LaboratoireRepository laboratoireRepository;

    @Autowired
    public LaboratoireService(LaboratoireRepository laboratoireRepository) {
        this.laboratoireRepository = laboratoireRepository;
    }

    public Laboratoire createLaboratoire(Laboratoire laboratoire){
        return laboratoireRepository.save(laboratoire);
    }
    public List<Laboratoire> readLaboratoire(Integer id){
        return laboratoireRepository.findAll();
    }
    public Laboratoire updateLaboratoire(Laboratoire laboratoire){
        return laboratoireRepository.save(laboratoire);
    }
    public void deleteLaboratoire(Integer id){
        laboratoireRepository.deleteById(id);
    }

    ///
    public Laboratoire getLaboratoireById(Integer id){
        return laboratoireRepository.findById(id).orElse(null);
    }
}
