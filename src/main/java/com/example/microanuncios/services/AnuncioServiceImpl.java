package com.example.microanuncios.services;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.model.Anuncio;

import com.example.microanuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnuncioServiceImpl implements AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Override
    public List<Anuncio> findAll() {
        return anuncioRepository.findAll();
    }

    @Override
    public Optional<Anuncio> findById(int id) {
        return anuncioRepository.findById(id);
    }

    @Override
    public void Save(Anuncio anuncio) {
        anuncioRepository.save(anuncio);
    }

    @Override
    public Anuncio update(AnuncioDTO anuncioDTO) {

        Anuncio anuncioUpdated = new Anuncio(
                anuncioDTO.getId_anuncio(),
                anuncioDTO.getUser(),
                anuncioDTO.getTitulo(),
                anuncioDTO.getDescripcion(),
                anuncioDTO.getPrecio(),
                anuncioDTO.getFecha_publicacion(),
                anuncioDTO.getUsuario()
        );
        anuncioRepository.save(anuncioUpdated);
        return anuncioUpdated;

    }

    @Override
    public void deleteAllByCategoriaId(int id) {
        List<Anuncio> anuncios = findAllByCategoriaID(id);
        for (Anuncio a : anuncios){
            anuncioRepository.delete(a);
        }
    }

    @Override
    public List<Anuncio> findAllByCategoriaID(int id) {

        List<Anuncio> anuncios = anuncioRepository.findAll();
        List<Anuncio> anunciosListById = anuncios.stream().filter(anuncio -> anuncio.equals(anuncio.getId())).collect(Collectors.toList());
        return anunciosListById;
    }
}
