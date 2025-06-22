package com.skillnest.cine.repository;

import com.skillnest.cine.model.Directores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoresRepository extends JpaRepository<Directores, Long> {
}
