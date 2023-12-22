package com.sheryians.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheryians.major.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
