package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.Roles;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Optional<Role> findByRole(Roles role);
}
