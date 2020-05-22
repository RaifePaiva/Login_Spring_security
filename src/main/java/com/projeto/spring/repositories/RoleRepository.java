package com.projeto.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.spring.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	

}
