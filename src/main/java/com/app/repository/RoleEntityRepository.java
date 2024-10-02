package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {

}
