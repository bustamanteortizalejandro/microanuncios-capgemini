package com.example.microanuncios.dto;

import java.util.Date;

public class AnuncioDTO {
    private int id_anuncio;
    private int id_categoria;
    private String user;
    private String titulo;
    private String descripcion;
    private double precio;
    private Date fecha_publicacion;

    public AnuncioDTO() {
    }


    public AnuncioDTO(int id_anuncio, int id_categoria, String user, String titulo, String descripcion, double precio, Date fecha_publicacion) {
        this.id_anuncio = id_anuncio;
        this.id_categoria = id_categoria;
        this.user = user;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_publicacion = fecha_publicacion;
    }

    public AnuncioDTO(int id_anuncio, String user, String titulo, String descripcion, double precio, Date fecha_publicacion) {
        this.id_anuncio = id_anuncio;
        this.user = user;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(int id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }



    @Override
    public String toString() {
        return "AnuncioDTO{" +
                "id_anuncio=" + id_anuncio +
                ", id_categoria=" + id_categoria +
                ", user='" + user + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fecha_publicacion=" + fecha_publicacion +
                '}';
    }
}
