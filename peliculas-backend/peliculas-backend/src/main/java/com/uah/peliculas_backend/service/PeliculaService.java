package com.uah.peliculas_backend.service;

import com.uah.peliculas_backend.model.Pelicula;
import com.uah.peliculas_backend.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PeliculaService {

    private final PeliculaRepository repo;

    public PeliculaService(PeliculaRepository repo) {
        this.repo = repo;
    }

    public List<Pelicula> findAll() {
        return repo.findAll();
    }

    public Optional<Pelicula> findById(Long id) {
        return repo.findById(id);
    }

    public Pelicula save(Pelicula pelicula) {
        return repo.save(pelicula);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


    public List<Pelicula> buscarPorTitulo(String titulo) {
        return repo.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return repo.findByGeneroContainingIgnoreCase(genero);
    }

    public List<Pelicula> buscarPorActor(String actor) {
        return repo.buscarPorActor(actor);
    }

    public List<Pelicula> buscar(String q) {
        if (q == null || q.trim().isEmpty()) {
            return findAll();
        }

        String term = q.trim();
        Set<Pelicula> resultSet = new LinkedHashSet<>();

        List<Pelicula> byTitle = buscarPorTitulo(term);
        if (byTitle != null) resultSet.addAll(byTitle);

        List<Pelicula> byGenre = buscarPorGenero(term);
        if (byGenre != null) resultSet.addAll(byGenre);

        List<Pelicula> byActor = buscarPorActor(term);
        if (byActor != null) resultSet.addAll(byActor);

        return new ArrayList<>(resultSet);
    }
}
