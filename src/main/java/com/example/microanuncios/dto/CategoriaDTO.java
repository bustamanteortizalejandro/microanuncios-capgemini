package com.example.microanuncios.dto;

import com.example.microanuncios.model.Anuncio;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {
    private int id;
    private String nombre;
    private List<Anuncio> anuncios = new ArrayList<>();

    public CategoriaDTO() {
    }

    public CategoriaDTO(int id, String nombre, List<Anuncio> anuncios) {
        this.id = id;
        this.nombre = nombre;
        this.anuncios = anuncios;
    }

    public CategoriaDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anuncios=" + anuncios +
                '}';
    }
}
