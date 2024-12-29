package com.mg.app.PharmaSys.repository.utilisateur;

import com.mg.app.PharmaSys.model.utilisateur.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}