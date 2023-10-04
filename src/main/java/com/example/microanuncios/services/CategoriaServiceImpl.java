package com.example.microanuncios.services;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AnuncioService anuncioService;

    @Override
    public List<Categoria> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoriaDTO> findAllDTO() {
        List<Categoria> categorias= categoryRepository.findAll();
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

        for(Categoria categoria: categorias){
                   categoriaDTOS.add(parseCategoria(categoria));
        }
        return categoriaDTOS;

    }

    @Override
    public Optional<Categoria> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public CategoriaDTO findByIdDTO(int id) {
        Categoria categoria = findById(id).get();
        if(categoria ==null){
            throw new IllegalArgumentException("El objeto no puede ser nulo");
        }
        CategoriaDTO categoriaDTO = parseCategoria(categoria);
        return categoriaDTO;

    }

    @Override
    public void Save(Categoria categoria) {
        categoryRepository.save(categoria);
    }

    @Override
    public CategoriaDTO update(CategoriaDTO categoriaDTO) {
        if (categoryRepository.findById(categoriaDTO.getId()).isPresent()) {
            Categoria udpateCategoria = parseCategoriaDTO(categoriaDTO);
            categoryRepository.save(udpateCategoria);
            return parseCategoria(udpateCategoria);
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
    public CategoriaDTO parseCategoria(Categoria categoria) {

        CategoriaDTO categoriaDTO = new CategoriaDTO(
                categoria.getId(),
                categoria.getDescripcion()
        );

        return categoriaDTO;
    }

    @Override
    public CategoriaDTO saveNewCategoria(CategoriaDTO categoriaDTO) {

        if (!categoryRepository.findById(categoriaDTO.getId()).isPresent()) {
            Categoria categoria = parseCategoriaDTO(categoriaDTO);
            categoryRepository.save(categoria);
            return parseCategoria(categoria);
        } else {
            throw new IllegalArgumentException("Está categoria ya existe");
        }
    }

    @Override
    public boolean deleteById(int id) {

        Optional<Categoria> categoria = categoryRepository.findById(id);

        if (!categoria.isPresent()) {
            throw new IllegalArgumentException("Está categoria no existe");
        }
        anuncioService.deleteAllByCategoriaId(id);
        categoryRepository.deleteById(id);
        return true;
    }
}
