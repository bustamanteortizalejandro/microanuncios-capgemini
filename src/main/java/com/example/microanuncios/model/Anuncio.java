package com.example.microanuncios.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="anuncios")
public class Anuncio {
    @Id
    @Column(name = "id_anuncio")
    private int id;
    @JoinColumn(name="id_categoria")
    @ManyToOne
    private Categoria categoria;
    private String user;
    private String titulo;
    private String descripcion;
    private double precio;
    private Date fecha_publicacion;
    private String usuario;


    public Anuncio() {
    }

    public Anuncio(int id, String user, String titulo, String descripcion, double precio, Date fecha_publicacion, String usuario) {
        this.id = id;
        this.user = user;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_publicacion = fecha_publicacion;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
