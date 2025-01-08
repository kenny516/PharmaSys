package com.mg.app.PharmaSys.service.fournisseur;

import com.mg.app.PharmaSys.model.fournisseur.EntreeFournisseur;
import com.mg.app.PharmaSys.repository.fournisseur.EntreeFournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EntreeFournisseurService {
    private final EntreeFournisseurRepository entreeFournisseurRepository;

    private EntreeFournisseur createEntreFournisseur(EntreeFournisseur entreeFournisseur) {
        return entreeFournisseurRepository.save(entreeFournisseur);
    }
    private List<EntreeFournisseur> readEntreeFournisseurs() {
        return entreeFournisseurRepository.findAll();
    }
    private EntreeFournisseur updateEntreeFournisseur(EntreeFournisseur entreeFournisseur) {
        return entreeFournisseurRepository.save(entreeFournisseur);
    }
    private void deleteEntreeFournisseur(Integer id) {
        entreeFournisseurRepository.deleteById(id);
    }

    private EntreeFournisseur getEntreeFournisseurById(Integer id) {
        return entreeFournisseurRepository.findById(id).orElse(null);
    }



}
