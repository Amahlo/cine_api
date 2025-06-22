package com.skillnest.cine.repository;

import com.skillnest.cine.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculasRepository extends JpaRepository<Peliculas, Long> {

    //Mostrar todas las películas dirigidas por un director
    List<Peliculas> findByDirectores_Id(Long directorId);

    //Mostrar todas las películas de un género
    List<Peliculas> findByGeneroId(Long generoId);

}
