package com.skillnest.cine.repository;

import com.skillnest.cine.model.Actores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActoresRepository extends JpaRepository<Actores, Long> {
}
