package com.uah.peliculas.frontend.service;

import com.uah.peliculas.frontend.model.Actor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

@Service
public class ActorFrontendService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/api/actores";

    @Autowired
    public ActorFrontendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Actor> listarActores() {
        ResponseEntity<Actor[]> resp = restTemplate.getForEntity(BASE_URL, Actor[].class);
        Actor[] arr = resp.getBody();
        return arr == null ? List.of() : Arrays.asList(arr);
    }
    public Actor getActor(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Actor.class);
    }
    public Actor crearActor(Actor actor) {
        return restTemplate.postForObject(BASE_URL, actor, Actor.class);
    }
    public void actualizarActor(Long id, Actor actor) {
        restTemplate.put(BASE_URL + "/" + id, actor);
    }
    public void eliminarActor(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}

