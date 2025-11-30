package com.uah.peliculas.frontend.model;

import java.time.LocalDate;

public class Actor {
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;

    public Actor(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public String getPaisNacimiento() {return paisNacimiento;}
    public void setPaisNacimiento(String paisNacimiento) {this.paisNacimiento = paisNacimiento;}

}
