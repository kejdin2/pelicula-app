package com.uah.peliculas.frontend.service;

import com.uah.peliculas.frontend.model.Pelicula;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class PeliculaFrontendService {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/peliculas";

    @Autowired
    public PeliculaFrontendService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Pelicula> listarPeliculas(){
        ResponseEntity<Pelicula[]> resp = restTemplate.getForEntity(BASE_URL, Pelicula[].class);
        Pelicula[] arr = resp.getBody();
        return arr == null ? List.of() : Arrays.asList(arr);
    }

    public List<Pelicula> buscar(String q) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/search")
                .queryParam("q", q == null ? "" : q);
        ResponseEntity<Pelicula[]> resp = restTemplate.getForEntity(builder.toUriString(), Pelicula[].class);
        Pelicula[] arr = resp.getBody();
        return arr == null ? List.of() : Arrays.asList(arr);
    }

    public Pelicula getPelicula(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Pelicula.class);
    }

    public Pelicula crearPelicula(Pelicula pelicula) {
        return restTemplate.postForObject(BASE_URL, pelicula, Pelicula.class);
    }

    public void actualizarPelicula(Long id, Pelicula pelicula) {
        restTemplate.put(BASE_URL + "/" + id, pelicula);
    }

    public void eliminarPelicula(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
