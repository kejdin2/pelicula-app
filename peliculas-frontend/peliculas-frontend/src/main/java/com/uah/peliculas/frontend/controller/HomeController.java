package com.uah.peliculas.frontend.controller;

import com.uah.peliculas.frontend.model.Pelicula;
import com.uah.peliculas.frontend.service.PeliculaFrontendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    private final PeliculaFrontendService peliculaService;

    public HomeController(PeliculaFrontendService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(required = false) String q,
            Model model
    ) {

        List<Pelicula> peliculas;

        if (q != null && !q.isBlank()) {
            peliculas = peliculaService.buscar(q);
            model.addAttribute("query", q);
        } else {
            peliculas = peliculaService.listarPeliculas();
        }

        Pelicula destacada = null;
        if (!peliculas.isEmpty()) {
            destacada = peliculas.get(new Random().nextInt(peliculas.size()));
        }

        model.addAttribute("peliculas", peliculas);
        model.addAttribute("destacada", destacada);

        return "home";
    }
}
