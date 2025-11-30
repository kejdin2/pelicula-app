package com.uah.peliculas_backend.repository;

import com.uah.peliculas_backend.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
