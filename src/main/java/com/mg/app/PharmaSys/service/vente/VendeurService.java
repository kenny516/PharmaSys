package com.mg.app.PharmaSys.service.vente;

import com.mg.app.PharmaSys.model.vente.Vendeur;
import com.mg.app.PharmaSys.repository.vente.VendeurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VendeurService {
    VendeurRepository vendeurRepository;

    public List<Vendeur> readVendeurs(){
        return vendeurRepository.findAll();
    }

    public Vendeur createVendeur(Vendeur vendeur){
        return vendeurRepository.save(vendeur);
    }

    public Vendeur updateVendeur(Vendeur vendeur){
        return vendeurRepository.save(vendeur);
    }

    public void deleteVendeur(Integer id){
        vendeurRepository.deleteById(id);
    }


    public Vendeur getVendeurById(Integer id){
        return vendeurRepository.findById(id).orElse(null);
    }





}
