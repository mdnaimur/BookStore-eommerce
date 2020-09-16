package com.mnr.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.mnr.bookstore.model.security.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{
	
	Role findByName(String name);

}
