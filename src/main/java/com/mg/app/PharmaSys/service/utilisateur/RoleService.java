package com.mg.app.PharmaSys.service.utilisateur;

import com.mg.app.PharmaSys.model.utilisateur.Role;
import com.mg.app.PharmaSys.repository.utilisateur.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> readRole() {
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
