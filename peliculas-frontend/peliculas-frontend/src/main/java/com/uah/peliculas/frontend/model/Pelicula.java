package com.uah.peliculas.frontend.model;

import java.util.List;

public class Pelicula {

    private Long id;
    private String titulo;
    private Integer year;
    private Integer duracion;
    private String pais;
    private String direccion;
    private String genero;
    private String sinopsis;
    private String portada;
    private List<Actor> actores;

    public Pelicula(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public Integer getYear() {return year;}
    public void setYear(Integer year) {this.year = year;}

    public Integer getDuracion() {return duracion;}
    public void setDuracion(Integer duracion) {this.duracion = duracion;}

    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}

    public String getSinopsis() {return sinopsis;}
    public void setSinopsis(String sinopsis) {this.sinopsis = sinopsis;}

    public String getPortada() {return portada;}
    public void setImagen(String imagen) {this.portada = portada;}

    public List<Actor> getActores() {return actores;}
    public void setActores(List<Actor> actores) {this.actores = actores;}

}



