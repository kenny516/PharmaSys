package com.mg.app.PharmaSys.repository.medicament;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {
}