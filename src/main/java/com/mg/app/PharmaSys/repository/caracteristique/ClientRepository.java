package com.mg.app.PharmaSys.repository.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Client;
import com.mg.app.PharmaSys.model.caracteristique.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}