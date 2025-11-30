package com.uah.peliculas.frontend.controller;

import com.uah.peliculas.frontend.model.Pelicula;
import com.uah.peliculas.frontend.model.Actor;
import com.uah.peliculas.frontend.service.PeliculaFrontendService;
import com.uah.peliculas.frontend.service.ActorFrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaFrontendController {

    @Autowired
    private PeliculaFrontendService peliculaService;

    @Autowired
    private ActorFrontendService actorService;

    @GetMapping
    public String listar(@RequestParam(name = "q", required = false) String q, Model model) {
        List<Pelicula> peliculas;
        if (q != null && !q.trim().isEmpty()) {
            peliculas = peliculaService.buscar(q.trim());
        } else {
            peliculas = peliculaService.listarPeliculas();
        }
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("q", q); // keep the query text in the form
        return "peliculas/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("actores", actorService.listarActores());
        return "peliculas/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Pelicula p = peliculaService.getPelicula(id);
        model.addAttribute("pelicula", p);
        model.addAttribute("actores", actorService.listarActores());
        return "peliculas/form";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Pelicula pelicula = peliculaService.getPelicula(id);
        if (pelicula == null) {
            return "redirect:/";  // OR redirect:/peliculas
        }
        model.addAttribute("pelicula", pelicula);
        return "peliculas/detalle";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pelicula pelicula) {
        if (pelicula.getId() == null) {
            peliculaService.crearPelicula(pelicula);
        } else {
            peliculaService.actualizarPelicula(pelicula.getId(), pelicula);
        }
        return "redirect:/peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }
}
