package com.uah.peliculas_backend.controller;

import com.uah.peliculas_backend.model.Actor;
import com.uah.peliculas_backend.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actores")
@CrossOrigin("*")
public class ActorController {

    private final ActorService service;

    public ActorController(ActorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Actor> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Actor obtener(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Actor crear(@RequestBody Actor actor) {
        return service.save(actor);
    }

    @PutMapping("/{id}")
    public Actor actualizar(@PathVariable Long id, @RequestBody Actor actor) {
        actor.setId(id);
        return service.save(actor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }
}
