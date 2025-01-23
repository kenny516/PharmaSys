package com.mg.app.PharmaSys.service.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Sexe;
import com.mg.app.PharmaSys.repository.caracteristique.SexeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SexeService {
    private final SexeRepository sexeRepository;

    public List<Sexe> getSexe(){
        return sexeRepository.findAll();
    }
    public Sexe updateSexe(Sexe sexe){
        return sexeRepository.save(sexe);
    }
    public void deleteSexe(Integer id){
        sexeRepository.deleteById(id);
    }
    public Sexe getSexeById(Integer id){
        return sexeRepository.findById(id).orElse(null);
    }



}
