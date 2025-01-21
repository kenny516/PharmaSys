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

    public List<Vendeur> vendeurList(){
        return vendeurRepository.findAll();
    }


}
