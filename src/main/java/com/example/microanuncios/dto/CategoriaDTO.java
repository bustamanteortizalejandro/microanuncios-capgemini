package com.example.microanuncios.dto;

import com.example.microanuncios.model.Anuncio;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {
    private int id;
    private String descripcion;
    private List<Anuncio> anuncios = new ArrayList<>();



    public CategoriaDTO() {
    }

    public CategoriaDTO(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
                ", descripcion='" + descripcion + '\'' +
                ", anuncios=" + anuncios +
                '}';
    }
}
