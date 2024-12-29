package com.mg.app.PharmaSys;

import com.mg.app.PharmaSys.model.utilisateur.Role;
import com.mg.app.PharmaSys.service.utilisateur.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PharmaSysApplicationTests {
	@Autowired
	RoleService roleService;

	@Test
	void contextLoads() {
		Role role = new Role();
		role.setNom("ADMIN");
		role.setDescription("Administrateur");
		roleService.createRole(role);

		List<Role> roles = roleService.readRole();
		for (Role r : roles) {
			System.out.println(r.getNom());
		}
	}

}
