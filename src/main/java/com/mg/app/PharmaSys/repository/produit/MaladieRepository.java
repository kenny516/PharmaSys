package com.mg.app.PharmaSys.repository.produit;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.app.PharmaSys.model.caracteristique.Maladie;

public interface MaladieRepository extends JpaRepository<Maladie, Integer> {
}