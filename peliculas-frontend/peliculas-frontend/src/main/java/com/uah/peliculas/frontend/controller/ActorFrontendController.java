package com.uah.peliculas.frontend.controller;

import com.uah.peliculas.frontend.model.Actor;
import com.uah.peliculas.frontend.service.ActorFrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/actores")
public class ActorFrontendController {

    @Autowired
    private ActorFrontendService actorService;

    @GetMapping
    public String listar(Model model) {
        List<Actor> actores = actorService.listarActores();
        model.addAttribute("actores", actores);
        return "actores/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("actor", new Actor());
        return "actores/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Actor a = actorService.getActor(id);
        model.addAttribute("actor", a);
        return "actores/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Actor actor) {
        if (actor.getId() == null) {
            actorService.crearActor(actor);
        } else {
            actorService.actualizarActor(actor.getId(), actor);
        }
        return "redirect:/actores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        actorService.eliminarActor(id);
        return "redirect:/actores";
    }
}
