package com.mg.app.PharmaSys.repository.maladie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.app.PharmaSys.model.maladie.Maladie;

public interface MaladieRepository extends JpaRepository<Maladie, Integer> {
}