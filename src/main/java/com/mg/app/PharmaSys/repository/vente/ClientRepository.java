package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.model.caracteristique.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}