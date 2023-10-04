package com.example.microanuncios.services;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface AnuncioService {
    public List<Anuncio> findAll();

    public Optional<Anuncio> findById(int id);

    public void Save(Anuncio anuncio);

    public Anuncio update(AnuncioDTO anuncioDTO);

    public void deleteAllByCategoriaId(int id);

    public List<Anuncio> findAllByCategoriaID(int id);
}
