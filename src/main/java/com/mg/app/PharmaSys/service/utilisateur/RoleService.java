package com.mg.app.PharmaSys.service.utilisateur;

import com.mg.app.PharmaSys.model.utilisateur.Role;
import com.mg.app.PharmaSys.repository.utilisateur.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;


    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    ///
    public Role getRoleById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

}
