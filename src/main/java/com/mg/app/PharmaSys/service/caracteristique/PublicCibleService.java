package com.mg.app.PharmaSys.service.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.repository.caracteristique.PublicCibleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PublicCibleService {
    private final PublicCibleRepository publicCibleRepository;

    public PublicCible createPublicCible(PublicCible publicCible){
        return publicCibleRepository.save(publicCible);
    }
    public List<PublicCible> getAllPublicCible(){
        return publicCibleRepository.findAll();
    }
    public PublicCible updatePublicCible(PublicCible publicCible){
        return publicCibleRepository.save(publicCible);
    }
    public void deletePublicCible(Integer id){
        publicCibleRepository.deleteById(id);
    }

    public PublicCible getPublicCibleById(Integer id){
        return publicCibleRepository.findById(id).orElse(null);
    }



}
