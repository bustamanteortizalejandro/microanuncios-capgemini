package com.example.microanuncios.services;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    public List<Categoria> findAll();

    public List<CategoriaDTO> findAllDTO();

    public Optional<Categoria> findById(int id);

    public CategoriaDTO findByIdDTO(int id);

    public void Save(Categoria anuncio);

    public CategoriaDTO update(CategoriaDTO categoriaDTO);

    public Categoria parseCategoriaDTO(CategoriaDTO categoriaDTO);

    public CategoriaDTO parseCategoria(Categoria categoria);

    public CategoriaDTO saveNewCategoria(CategoriaDTO categoriaDTO);

    public ResponseEntity<String> deleteById(int id);


}
