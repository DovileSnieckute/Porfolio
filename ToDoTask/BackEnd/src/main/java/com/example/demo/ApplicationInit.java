package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Role;
import com.example.demo.entity.Roles;
import com.example.demo.repository.RoleRepository;

@Component
public class ApplicationInit implements ApplicationRunner {
	
	@Autowired
	RoleRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		if(repository.findByRole(Roles.ROLE_USER).isEmpty()) {
			Role user = new Role();
			user.setRole(Roles.ROLE_USER);
			repository.save(user);
		}
		
		if(repository.findByRole(Roles.ROLE_ADMIN).isEmpty()) {
			Role user = new Role();
			user.setRole(Roles.ROLE_ADMIN);
			repository.save(user);
		}
		
		
	}
	

}
