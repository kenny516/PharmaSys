package com.mg.app.PharmaSys.service.fournisseur;

import com.mg.app.PharmaSys.model.fournisseur.Fournisseur;
import com.mg.app.PharmaSys.repository.fournisseur.FournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }
    public List<Fournisseur> readFournisseurs() {
        return fournisseurRepository.findAll();
    }
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }
    public void deleteFournisseur(Integer id) {
        fournisseurRepository.deleteById(id);
    }

    public Fournisseur getFournisseurById(Integer id) {
        return fournisseurRepository.findById(id).orElse(null);
    }
}
