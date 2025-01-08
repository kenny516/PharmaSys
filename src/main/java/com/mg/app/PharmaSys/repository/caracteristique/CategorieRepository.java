package com.mg.app.PharmaSys.repository.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
