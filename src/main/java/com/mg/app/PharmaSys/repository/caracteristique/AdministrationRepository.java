package com.mg.app.PharmaSys.repository.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrationRepository extends JpaRepository<Administration, Integer> {
    // Vous pouvez ajouter des méthodes spécifiques ici si nécessaire
}
