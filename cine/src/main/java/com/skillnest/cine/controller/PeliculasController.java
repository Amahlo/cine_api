package com.skillnest.cine.controller;

import com.skillnest.cine.model.Peliculas;
import com.skillnest.cine.service.PeliculasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@RequiredArgsConstructor
public class PeliculasController {

    private final PeliculasService peliculasService;

    //Mostrar todas las películas
    @GetMapping
    public ResponseEntity<List<Peliculas>> getPeliculas() {
        List<Peliculas> peliculas = peliculasService.allPeliculas();
        return new ResponseEntity<>(peliculas, HttpStatus.OK);
    }

    //Mostrar película
    @GetMapping("/{id}")
    public ResponseEntity<Peliculas> getPelicula(@PathVariable Long id) {
        Peliculas pelicula = peliculasService.getPelicula(id);
        if(pelicula == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pelicula, HttpStatus.OK);
    }

    //Crear película
    @PostMapping
    public ResponseEntity<Peliculas> createPelicula(@Valid @RequestBody Peliculas peliculas) {
        Peliculas createdPelicula = peliculasService.newPelicula(peliculas);
        return new ResponseEntity<>(createdPelicula, HttpStatus.CREATED);
    }

    //Actualizar película
    @PutMapping("/{id}")
    public ResponseEntity<Peliculas> updatePelicula(@PathVariable Long id, @RequestBody Peliculas peliculas) {
        Peliculas updatedPelicula = peliculasService.updatePelicula(id, peliculas);
        if(updatedPelicula == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPelicula, HttpStatus.OK);
    }

    //Borrar película
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable Long id) {
        if(peliculasService.deletePelicula(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Mostrar todas las películas dirigidas por un director
    @GetMapping("directores/{directorId}/peliculas")
    public ResponseEntity<List<Peliculas>> getPeliculasByDirector(@PathVariable Long directorId) {
        List<Peliculas> peliculasByDirector = peliculasService.getPelicuasByDirectorId(directorId);
        if (peliculasByDirector.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(peliculasByDirector, HttpStatus.OK);
    }

    //Mostrar todas las películas de un género
    @GetMapping("generos/{generoId}/peliculas")
    public ResponseEntity<List<Peliculas>> getPeliculasByGenero(@PathVariable Long generoId) {
        List<Peliculas> peliculasByGenero = peliculasService.getPeliculasByGeneroID(generoId);
        if (peliculasByGenero.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(peliculasByGenero, HttpStatus.OK);
    }


}
