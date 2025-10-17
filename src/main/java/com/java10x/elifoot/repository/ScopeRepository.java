package com.java10x.elifoot.repository;

import com.java10x.elifoot.entity.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScopeRepository extends JpaRepository<Scope, Long> {
}
