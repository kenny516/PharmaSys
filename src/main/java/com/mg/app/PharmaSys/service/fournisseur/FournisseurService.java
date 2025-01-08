package com.mg.app.PharmaSys.service.fournisseur;

import com.mg.app.PharmaSys.model.fournisseur.Fournisseur;
import com.mg.app.PharmaSys.repository.fournisseur.FournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    private Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }
    private Fournisseur readFournisseur(Integer id) {
        return fournisseurRepository.findById(id).orElse(null);
    }
    private Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }
    private void deleteFournisseur(Integer id) {
        fournisseurRepository.deleteById(id);
    }

    private Fournisseur getFournisseurById(Integer id) {
        return fournisseurRepository.findById(id).orElse(null);
    }
}
