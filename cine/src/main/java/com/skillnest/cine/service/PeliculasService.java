package com.skillnest.cine.service;

import com.skillnest.cine.model.Peliculas;
import com.skillnest.cine.repository.PeliculasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeliculasService {

    private final PeliculasRepository peliculasRepository;

    //Todas las peliculas
    public List<Peliculas> allPeliculas() {
        return peliculasRepository.findAll();
    }

    //Mostrar pelicula
    public Peliculas getPelicula(Long id) {
        return peliculasRepository.findById(id).orElse(null);
    }

    //Crear pelicula
    public Peliculas newPelicula(Peliculas peliculas) {
        return peliculasRepository.save(peliculas);
    }

    //Actualizar pelicula
    public Peliculas updatePelicula(Long id, Peliculas peliculas) {
        Optional<Peliculas> peliculaExist = peliculasRepository.findById(id);
        if(peliculaExist.isPresent()){
            peliculas.setId(id);
            return peliculasRepository.save(peliculas);
        }
        return  null;
    }

    //Borrar pelicula
    public boolean deletePelicula(Long id) {
        Optional<Peliculas> peliculaExist = peliculasRepository.findById(id);
        if(peliculaExist.isPresent()) {
            peliculasRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Películas dirigidas por un director
    public List<Peliculas> getPelicuasByDirectorId(Long directorId) {
        return peliculasRepository.findByDirectores_Id(directorId);
    }

    //Películas de un género
    public List<Peliculas> getPeliculasByGeneroID(Long generoId) {
        return peliculasRepository.findByGeneroId(generoId);
    }

}
