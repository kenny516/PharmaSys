package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.Unite;
import com.mg.app.PharmaSys.repository.produit.UniteRepository;
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


}
