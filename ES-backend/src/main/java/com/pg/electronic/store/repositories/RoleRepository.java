package com.pg.electronic.store.repositories;

import com.pg.electronic.store.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
