package com.mg.app.PharmaSys.service.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Laboratoire;
import com.mg.app.PharmaSys.repository.caracteristique.LaboratoireRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LaboratoireService {
    private final LaboratoireRepository laboratoireRepository;

    public Laboratoire createLaboratoire(Laboratoire laboratoire){
        return laboratoireRepository.save(laboratoire);
    }
    public List<Laboratoire> getAllLaboratoire(){
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
