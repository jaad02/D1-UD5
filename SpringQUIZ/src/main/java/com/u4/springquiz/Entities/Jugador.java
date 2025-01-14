package com.u4.springquiz.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private Integer puntuacion;

    public Jugador(String nombre, Integer puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public Jugador() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
