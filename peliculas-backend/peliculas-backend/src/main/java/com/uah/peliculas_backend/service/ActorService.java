package com.uah.peliculas_backend.service;

import com.uah.peliculas_backend.model.Actor;
import com.uah.peliculas_backend.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository repo;

    public ActorService(ActorRepository repo) {
        this.repo = repo;
    }

    public List<Actor> findAll() { return repo.findAll(); }

    public Optional<Actor> findById(Long id) { return repo.findById(id); }

    public Actor save(Actor actor) { return repo.save(actor); }

    public void delete(Long id) { repo.deleteById(id); }
}

