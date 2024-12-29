package com.mg.app.PharmaSys.repository.utilisateur;

import com.mg.app.PharmaSys.model.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
