package com.comehomecar.repository;

import org.springframework.data.repository.CrudRepository;

import com.comehomecar.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
           Role findByname(String name);
}
