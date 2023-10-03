package com.example.microanuncios.services;

import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Categoria> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void Save(Categoria anuncio) {
        categoryRepository.save(anuncio);
    }

    @Override
    public Categoria update(CategoriaDTO categoriaDTO) {

        Categoria udpateCategoria = new Categoria(
                categoriaDTO.getId(),
                categoriaDTO.getNombre()
        );
        categoryRepository.save(udpateCategoria);
        return udpateCategoria;
    }
}
