package com.mg.app.PharmaSys.service.utilisateur;

import com.mg.app.PharmaSys.model.utilisateur.Utilisateur;
import com.mg.app.PharmaSys.repository.utilisateur.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    public List<Utilisateur> readUtilisateur(){
        return utilisateurRepository.findAll();
    }
    public Utilisateur updateUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    public void deleteUtilisateur(Integer id){
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur getUtilisateurById(Integer id){
        return utilisateurRepository.findById(id).orElse(null);
    }
}

