package com.example.microanuncios.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "anuncios")
public class Anuncio {
    @Id
    @Column(name = "id_anuncio")
    private int id;
    @JoinColumn(name = "id_categoria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;
    private String user;
    private String titulo;
    private String descripcion;
    private double precio;
    private Date fecha_publicacion;


    public Anuncio() {
    }

    public Anuncio(int id, Categoria categoria, String user, String titulo, String descripcion, double precio, Date fecha_publicacion) {
        this.id = id;
        this.categoria = categoria;
        this.user = user;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        return "Anuncio{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", user='" + user + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fecha_publicacion=" + fecha_publicacion +
                '}';
    }
}
