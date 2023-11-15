package com.dam.prova_u1_vcs.model;

import java.util.List;

public class Seleccion {
    private String nombre;
    private FootballPlayer[] listaJugadores;


    
    public Seleccion() {
    }

    
    public Seleccion(String nombre, FootballPlayer[] listaJugadores) {
        this.nombre = nombre;
        this.listaJugadores = listaJugadores;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public FootballPlayer[] getListaJugadores() {
        return listaJugadores;
    }
    public void setListaJugadores(FootballPlayer[] listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    
}
