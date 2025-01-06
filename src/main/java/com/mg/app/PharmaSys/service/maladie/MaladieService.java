package com.mg.app.PharmaSys.service.maladie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.app.PharmaSys.model.maladie.Maladie;
import com.mg.app.PharmaSys.repository.maladie.MaladieRepository;

@Service
public class MaladieService {
    private final MaladieRepository MaladieRepository;
    @Autowired
    public MaladieService(MaladieRepository MaladieRepository) {
        this.MaladieRepository = MaladieRepository;
    }

    public Maladie createMaladie(Maladie Maladie){
        return MaladieRepository.save(Maladie);
    }
    public List<Maladie> readMaladie(){
        return MaladieRepository.findAll();
    }
    public Maladie updateMaladie(Maladie Maladie){
        return MaladieRepository.save(Maladie);
    }
    public void deleteMaladie(Integer id){
        MaladieRepository.deleteById(id);
    }

    
    public Maladie getMaladieById(Integer id){
        return MaladieRepository.findById(id).orElse(null);
    }

}
