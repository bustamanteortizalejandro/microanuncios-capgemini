package com.example.microanuncios.services;

import com.example.microanuncios.controller.CategoriaController;
import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.model.Anuncio;

import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnuncioServiceImpl implements AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;
    @Lazy
    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<Anuncio> findAll() {
        return anuncioRepository.findAll();
    }

    @Override
    public Optional<Anuncio> findById(int id) {
        return anuncioRepository.findById(id);
    }

    @Override
    public void save(Anuncio anuncio) {
        anuncioRepository.save(anuncio);
    }

    @Override
    public void update(AnuncioDTO anuncioDTO) {

        Anuncio anuncio = anuncioRepository.findById(anuncioDTO.getId_anuncio()).get();
        Categoria categoria = categoriaService.findById(anuncioDTO.getId_categoria()).get();

        anuncio.setId(anuncioDTO.getId_anuncio());
        anuncio.setCategoria(categoria);
        anuncio.setTitulo(anuncioDTO.getTitulo());
        anuncio.setDescripcion(anuncioDTO.getDescripcion());
        anuncio.setPrecio(anuncioDTO.getPrecio());
        anuncio.setDescripcion(anuncioDTO.getDescripcion());
        anuncioRepository.save(anuncio);
    }

    @Override
    public void deleteAllByCategoriaId(int id) {
        List<Anuncio> anuncios = findAllByCategoriaID(id);
        for (Anuncio a : anuncios) {
            anuncioRepository.delete(a);
        }
    }

    @Override
    public List<Anuncio> findAllByCategoriaID(int id) {

        List<Anuncio> anuncios = anuncioRepository.findAll();
        List<Anuncio> anunciosListById = anuncios.stream().filter(anuncio -> anuncio.equals(anuncio.getId())).collect(Collectors.toList());
        return anunciosListById;
    }

    @Override
    public Anuncio parseAnuncioDTO(AnuncioDTO anuncioDTO) {
        Anuncio updatedAnuncio = new Anuncio(

                anuncioDTO.getId_anuncio(),
                new Categoria(anuncioDTO.getId_categoria()),
                anuncioDTO.getUser(),
                anuncioDTO.getTitulo(),
                anuncioDTO.getDescripcion(),
                anuncioDTO.getPrecio(),
                anuncioDTO.getFecha_publicacion()
        );

        return updatedAnuncio;
    }

    @Override
    public AnuncioDTO parseAnuncio(Anuncio anuncio) {

        AnuncioDTO anuncioDTO = new AnuncioDTO(
                anuncio.getId(),
                anuncio.getCategoria().getId(),
                anuncio.getUser(),
                anuncio.getTitulo(),
                anuncio.getDescripcion(),
                anuncio.getPrecio(),
                anuncio.getFecha_publicacion()
        );

        return anuncioDTO;
    }
}
