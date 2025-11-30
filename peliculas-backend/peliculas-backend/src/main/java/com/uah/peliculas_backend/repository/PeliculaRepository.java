package com.uah.peliculas_backend.repository;

import com.uah.peliculas_backend.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);

    List<Pelicula> findByGeneroContainingIgnoreCase(String genero);

    @Query("SELECT DISTINCT p FROM Pelicula p JOIN p.actores a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :actor, '%'))")
    List<Pelicula> buscarPorActor(@Param("actor") String actor);
}
