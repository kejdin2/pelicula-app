package com.uah.peliculas_backend.controller;

import com.uah.peliculas_backend.model.Pelicula;
import com.uah.peliculas_backend.service.PeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin("*")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelicula> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pelicula obtener(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Pelicula crear(@RequestBody Pelicula pelicula) {
        return service.save(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        return service.save(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<Pelicula> buscar(@RequestParam(required = false) String q) {
        return service.buscar(q);
    }
}
