package com.mg.app.PharmaSys.service.Maladies;

import com.mg.app.PharmaSys.model.Maladies.Maladies;
import com.mg.app.PharmaSys.repository.Maladies.MaladiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaladiesService {
    private final MaladiesRepository MaladiesRepository;
    @Autowired
    public MaladiesService(MaladiesRepository MaladiesRepository) {
        this.MaladiesRepository = MaladiesRepository;
    }

    public Maladies createMaladies(Maladies Maladies){
        return MaladiesRepository.save(Maladies);
    }

    public List<Maladies> readMaladies(){
        return MaladiesRepository.findAll();
    }
    public Maladies updateMaladies(Maladies Maladies){
        return MaladiesRepository.save(Maladies);
    }
    public void deleteMaladies(Integer id){
        MaladiesRepository.deleteById(id);
    }

    ///
    public Maladies getMaladiesById(Integer id){
        return MaladiesRepository.findById(id).orElse(null);
    }


}
