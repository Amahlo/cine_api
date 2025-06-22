package com.skillnest.cine.repository;

import com.skillnest.cine.model.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerosReposotory extends JpaRepository<Generos, Long> {
}
