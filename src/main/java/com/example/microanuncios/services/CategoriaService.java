package com.example.microanuncios.services;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    public List<Categoria> findAll();

    public Optional<Categoria> findById(int id);

    public void Save(Categoria anuncio);

    public Categoria update(CategoriaDTO categoriaDTO);
}
