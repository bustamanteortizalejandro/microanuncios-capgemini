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
    public void Save(Categoria categoria) {
        categoryRepository.save(categoria);
    }

    @Override
    public Categoria update(CategoriaDTO categoriaDTO) {
        if (categoryRepository.findById(categoriaDTO.getId()).isPresent()) {
            Categoria udpateCategoria = parseCategoriaDTO(categoriaDTO);
            categoryRepository.save(udpateCategoria);
            return udpateCategoria;
        } else {
            throw new IllegalArgumentException("La categoria no existe");
        }
    }

    @Override
    public Categoria parseCategoriaDTO(CategoriaDTO categoriaDTO) {

        if (categoriaDTO != null) {
            Categoria categoria = new Categoria(
                    categoriaDTO.getId(),
                    categoriaDTO.getDescripcion()
            );
            return categoria;
        } else {
            throw new IllegalArgumentException("El objeto CategoriaDTO no puede ser nulo");
        }
    }

    @Override
    public Categoria saveNewCategoria(CategoriaDTO categoriaDTO) {

        if(!categoryRepository.findById(categoriaDTO.getId()).isPresent()){
            Categoria categoria = parseCategoriaDTO(categoriaDTO);
            categoryRepository.save(categoria);
            return categoria;
        }else{
            throw new IllegalArgumentException("Está categoria ya existe");
        }
    }
}
