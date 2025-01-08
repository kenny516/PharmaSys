package com.mg.app.PharmaSys.service.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Unite;
import com.mg.app.PharmaSys.repository.caracteristique.UniteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UniteService {
    private final UniteRepository uniteRepository;

    public Unite createUnite(Unite unite){
        return uniteRepository.save(unite);
    }

    public List<Unite> readUnite(){
        return uniteRepository.findAll();
    }

    public Unite updateUnite(Unite unite){
        return uniteRepository.save(unite);
    }

    public void deleteUnite(Integer id) {
        uniteRepository.deleteById(id);
    }

    public Unite getUniteById(Integer id){
        return uniteRepository.findById(id).orElse(null);
    }


}
